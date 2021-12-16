package de.RepresentationalStateTransfer.database;

import de.RepresentationalStateTransfer.model.Product;

import javax.naming.InvalidNameException;
import java.security.InvalidKeyException;
import java.util.*;

public class ProductDatabase {

    private final SortedMap<Integer, Product> productsMap = new TreeMap<>();

    public static Product INVALID_PRODUCT = new Product(0, "INVALID_PRODUCT");

    public ProductDatabase(Product... initialProducts) {
        for (Product product : initialProducts) {
            productsMap.put(product.id(), product);
        }
    }

    // GET

    public Collection<Product> getAllProducts() {
        return productsMap.values();
    }

    public Product getProductById(int id) throws InvalidKeyException {
        if (productsMap.containsKey(id)) {
            return productsMap.get(id);
        }
        else{
            throw new InvalidKeyException();
        }
    }

    public Product getProductByName(String name) throws InvalidNameException {
        for (Product product : productsMap.values()){
            if (product.name().equalsIgnoreCase(name)){ // ignore case to allow for better search
                return product;
            }
        }

        throw new InvalidNameException();
    }

    public void printAllProducts(){
        System.out.println("All Products:");
        for (Product product : productsMap.values()){
            System.out.println(product.toString());
        }
    }

    // ADD

    public void addProducts(Product... newProducts) throws InvalidKeyException {
        for (Product newProduct : newProducts) addProduct(newProduct);
    }

    private void addProduct(Product newProduct) throws InvalidKeyException {
        if (!productsMap.containsKey(newProduct.id()))
            productsMap.put(newProduct.id(), newProduct);
        else
            throw new InvalidKeyException();
    }


    // REMOVE

    public void removeProducts(Product... productsToRemove) throws InvalidKeyException {
        for (Product product : productsToRemove) removeProduct(product);
    }

    private void removeProduct(Product productToRemove) throws InvalidKeyException {
        if (productsMap.containsKey(productToRemove.id()))
            productsMap.remove(productToRemove.id());
        else
            throw new InvalidKeyException();
    }
}
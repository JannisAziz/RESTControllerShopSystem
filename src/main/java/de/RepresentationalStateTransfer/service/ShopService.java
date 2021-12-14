package de.RepresentationalStateTransfer.service;

import de.RepresentationalStateTransfer.model.Order;
import de.RepresentationalStateTransfer.database.OrderRepo;
import de.RepresentationalStateTransfer.model.Product;
import de.RepresentationalStateTransfer.database.ProductDatabase;

import javax.naming.InvalidNameException;
import java.security.InvalidKeyException;
import java.util.Collection;


// Note: This is practically an interface for a 'front end(?)', as well as an error catching layer!
public class ShopService {

    private final ProductDatabase productDatabase;
    private final OrderRepo orderRepo;

    public ShopService(ProductDatabase productDB, OrderRepo orderRepo) {
        this.productDatabase = productDB;
        this.orderRepo = orderRepo;
    }

    /// PRODUCTS ///

    // GET

    public Collection<Product> getAllProducts() {
        return productDatabase.getAllProducts();
    }

    public Product getProductById(int id) {
        try {
            return productDatabase.getProductById(id);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        return productDatabase.INVALID_PRODUCT;
    }

    public Product getProductByName(String name) {
        try {
            return productDatabase.getProductByName(name);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }

        return productDatabase.INVALID_PRODUCT;
    }

    public void printAllProductsToConsole(){
        productDatabase.printAllProducts();
    }

    // ADD & REMOVE

    public String addNewProducts(Product... newProducts) {
        try {
            productDatabase.addProducts(newProducts);
            return "Added products!";
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return "InvalidKeyException! Does the Product already exist?";
        }
    }

    public String removeProducts(Product... productsToRemove) {
        try {
            productDatabase.removeProducts(productsToRemove);
            return "Removed products!";
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return "InvalidKeyException! Does the Product even exist?";
        }
    }

    /// ORDERS ///

    // GET

    public Collection<Order> getAllOrders() {
        return orderRepo.getAllOrders();
    }

    public Order getOrderById(int orderId) {
        try {
            return orderRepo.getOrderById(orderId);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        // Is there a way to handle this better?
        return null;
    }

    public void printAllOrders(){
        orderRepo.printAllOrders();
    }

    // ADD & REMOVE

    public String createNewOrder(int orderId, Collection<Product> productsToOrder) {
        try {
            orderRepo.createNewOrder(orderId, productsToOrder);
            return "Created order!";
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return "InvalidKeyException! Does the Order already exist?";
        }
    }

    public String removeOrders(int... orderIdsToRemove) {
        try {
            orderRepo.removeOrders(orderIdsToRemove);
            return "Removed order!";
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return "InvalidKeyException! Does the Order even exist?";
        }
    }
}
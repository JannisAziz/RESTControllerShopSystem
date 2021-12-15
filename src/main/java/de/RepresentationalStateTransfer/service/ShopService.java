package de.RepresentationalStateTransfer.service;

import de.RepresentationalStateTransfer.model.Order;
import de.RepresentationalStateTransfer.database.OrderRepo;
import de.RepresentationalStateTransfer.model.Product;
import de.RepresentationalStateTransfer.database.ProductDatabase;
import org.springframework.stereotype.Service;

import javax.naming.InvalidNameException;
import java.security.InvalidKeyException;
import java.util.Collection;

// Note: This is practically an interface for a 'front end(?)', as well as an error catching layer!
@Service
public class ShopService implements IShopService{

    private final ProductDatabase productDatabase = new ProductDatabase(
            new Product(1, "PRODUCT_FROM_DB_1"),
            new Product(2, "PRODUCT_FROM_DB_2")
    );

    private final OrderRepo orderRepo = new OrderRepo();

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

        return ProductDatabase.INVALID_PRODUCT;
    }

    public Product getProductByName(String name) {
        try {
            return productDatabase.getProductByName(name);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }

        return ProductDatabase.INVALID_PRODUCT;
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
            return "InvalidKeyException! Product already exists.";
        }
    }

    public String removeProducts(Product... productsToRemove) {
        try {
            productDatabase.removeProducts(productsToRemove);
            return "Removed products!";
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return "InvalidKeyException! Product doesn't exist.";
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

    public String addOrders(Order... orders) {
        try {
            orderRepo.addOrders(orders);
            return "Added orders!";
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return "InvalidKeyException! Order ID already exists.";
        }
    }

    public String removeOrders(int... orderIdsToRemove) {
        try {
            orderRepo.removeOrders(orderIdsToRemove);
            return "Removed orders!";
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return "InvalidKeyException! Order ID doesn't exists.";
        }
    }
}
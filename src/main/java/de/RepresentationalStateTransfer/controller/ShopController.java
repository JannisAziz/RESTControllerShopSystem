package de.RepresentationalStateTransfer.controller;

import de.RepresentationalStateTransfer.database.OrderRepo;
import de.RepresentationalStateTransfer.model.Order;
import de.RepresentationalStateTransfer.model.OrderWrapper;
import de.RepresentationalStateTransfer.model.Product;
import de.RepresentationalStateTransfer.database.ProductDatabase;

import de.RepresentationalStateTransfer.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("shop")
public class ShopController {

    private final ProductDatabase productDatabase = new ProductDatabase(
            Product.builder().id(1).name("Apple").build(),
            Product.builder().id(2).name("Banana").build(),
            Product.builder().id(3).name("Orange").build(),
            Product.builder().id(4).name("Milk").build(),
            Product.builder().id(5).name("Cereal").build()
    );

    private final ShopService shopService = new ShopService(productDatabase, new OrderRepo());

    /// PRODUCTS ///

    // GET

    @GetMapping("products")
    public Collection<Product> getAllProducts(){
        return shopService.getAllProducts();
    }

    @GetMapping("products/id={id}")
    public Product getProductById(@PathVariable int id){
        return shopService.getProductById(id);
    }

    @GetMapping("products/name={name}")
    public Product getProductByName(@PathVariable String name){
        return shopService.getProductByName(name);
    }

    // ADD & REMOVE

    @PutMapping("products")
    public String addProducts(@RequestBody Product... newProducts){
        return shopService.addNewProducts(newProducts);
    }

    @DeleteMapping("products")
    public String removeProduct(@RequestBody Product... productsToRemove){
        return shopService.removeProducts(productsToRemove);
    }

    /// ORDERS ///

    // GET

    @GetMapping("orders")
    public Collection<Order> getAllOrders(){
        return shopService.getAllOrders();
    }

    @GetMapping("orders/id={id}")
    public Order getOrderById(@PathVariable int id){
        return shopService.getOrderById(id);
    }

    // ADD & REMOVE

    @PutMapping("orders")
    public String createOrder(@RequestBody OrderWrapper newOrder) {
        return shopService.createNewOrder(
                newOrder.orderId, newOrder.productsToOrder
        );
    }

    @DeleteMapping("orders")
    public String removeOrder(@RequestBody int... orderIdsToRemove){
        return shopService.removeOrders(orderIdsToRemove);
    }
}
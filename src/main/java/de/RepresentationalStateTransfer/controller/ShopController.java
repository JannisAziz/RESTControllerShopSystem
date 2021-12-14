package de.RepresentationalStateTransfer.controller;

import de.RepresentationalStateTransfer.model.Order;
import de.RepresentationalStateTransfer.model.OrderWrapper;
import de.RepresentationalStateTransfer.model.Product;

import de.RepresentationalStateTransfer.service.IShopService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("shop")
public class ShopController {

    private IShopService service;

    public ShopController(IShopService shopService){
        this.service = shopService;
    }

    /// PRODUCTS ///

    // GET

    @GetMapping("products")
    public Collection<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("products/id={id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("products/name={name}")
    public Product getProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    // ADD & REMOVE

    @PutMapping("products")
    public String addProducts(@RequestBody Product... newProducts){
        return service.addNewProducts(newProducts);
    }

    @DeleteMapping("products")
    public String removeProduct(@RequestBody Product... productsToRemove){
        return service.removeProducts(productsToRemove);
    }

    /// ORDERS ///

    // GET

    @GetMapping("orders")
    public Collection<Order> getAllOrders(){
        return service.getAllOrders();
    }

    @GetMapping("orders/id={id}")
    public Order getOrderById(@PathVariable int id){
        return service.getOrderById(id);
    }

    // ADD & REMOVE

    @PutMapping("orders")
    public String createOrder(@RequestBody OrderWrapper newOrder) {
        return service.createNewOrder(
                newOrder.orderId, newOrder.productsToOrder
        );
    }

    @DeleteMapping("orders")
    public String removeOrders(@RequestBody int... orderIdsToRemove){
        return service.removeOrders(orderIdsToRemove);
    }
}
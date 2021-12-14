package de.RepresentationalStateTransfer.database;

import de.RepresentationalStateTransfer.model.Order;
import de.RepresentationalStateTransfer.model.Product;

import java.security.InvalidKeyException;
import java.util.*;

public class OrderRepo {

    private final Map<Integer, Order> orderMap = new HashMap<>();

    public static Order INVALID_ORDER = Order.builder().orderId(0).orderProducts(new ArrayList<>()).build();

    public OrderRepo(Order... initialOrders){
        for (Order newOrder : initialOrders){
            orderMap.put(newOrder.getOrderId(), newOrder);
        }
    }

    // GET

    public Collection<Order> getAllOrders() {
        return orderMap.values();
    }

    public Order getOrderById(int id) throws InvalidKeyException {
        if (orderMap.containsKey(id)) {
            return orderMap.get(id);
        }
        else{
            throw new InvalidKeyException();
        }
    }

    public void printAllOrders(){
        System.out.println("All Orders:");
        for (Order order : orderMap.values()){
            System.out.println(order.toString());
        }
    }

    // ADD
    public void createNewOrder(int id, Collection<Product> productsToOrder) throws InvalidKeyException {
        if (!orderMap.containsKey(id)) {
            Order newOrder = Order.builder()
                    .orderId(id)
                    .orderProducts(productsToOrder)
                    .build();

            orderMap.put(id, newOrder);
        }
        else{
            throw new InvalidKeyException();
        }
    }

    // REMOVE

    public void removeOrders(int... orderIdsToRemove) throws InvalidKeyException {
        for (int id : orderIdsToRemove) removeOrder(id);
    }

    private void removeOrder(int orderIDToRemove) throws InvalidKeyException {
        if (orderMap.containsKey(orderIDToRemove)) {
            orderMap.remove(orderIDToRemove);
        }
        else{
            throw new InvalidKeyException();
        }
    }
}

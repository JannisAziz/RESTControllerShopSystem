package de.RepresentationalStateTransfer.model;

import lombok.Builder;
import lombok.Data;

import java.util.*;

@Data
@Builder
public class Order {
    private final int orderId;
    private final Collection<Product> orderProducts;

    public int getOrderId() {
        return orderId;
    }

    public Collection<Product> getOrderProducts(){
        return orderProducts;
    }

    public void addProducts(Product... productsToAdd) {
        orderProducts.addAll(Arrays.asList(productsToAdd));
    }

    public void removeProducts(Product... productsToRemove){ orderProducts.removeAll(Arrays.asList(productsToRemove)); }

    public void printOrderProducts(){
        for (Product product : orderProducts){
            System.out.println(product.toString());
        }
    }

    @Override
    public String toString() {
        return "Order-" + orderId + ": " + orderProducts.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && orderProducts.equals(order.orderProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderProducts);
    }
}

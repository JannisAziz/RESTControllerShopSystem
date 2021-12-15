package de.RepresentationalStateTransfer.model;

import lombok.*;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int orderId;
    private Collection<Product> orderProducts = new ArrayList<>();

    // Implement these functions in OrderRepo, ShopService & Controller, to allow for order manipulation
    // public void addProducts(Product... productsToAdd) { orderProducts.addAll(Arrays.asList(productsToAdd)); }
    // public void removeProducts(Product... productsToRemove){ orderProducts.removeAll(Arrays.asList(productsToRemove)); }

    @Override
    public String toString() {
        return "Order-" + orderId + ": " + orderProducts.toString();
    }
}

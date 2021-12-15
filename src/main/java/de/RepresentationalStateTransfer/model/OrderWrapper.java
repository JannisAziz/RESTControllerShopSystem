package de.RepresentationalStateTransfer.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
public class OrderWrapper{
    public int orderId;
    public Collection<Product> productsToOrder;

    public OrderWrapper(int id, Collection<Product> productsToOrder){
        this.orderId = id;
        this.productsToOrder = productsToOrder;
    }
}
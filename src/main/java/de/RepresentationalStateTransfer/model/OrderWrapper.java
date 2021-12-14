package de.RepresentationalStateTransfer.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class OrderWrapper{
    public int orderId;
    public Collection<Product> productsToOrder;
}
package de.RepresentationalStateTransfer.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "ID-" + id + ": " + name;
    }
}

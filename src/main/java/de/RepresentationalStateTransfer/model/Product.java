package de.RepresentationalStateTransfer.model;

import lombok.Data;
import lombok.NonNull;

import java.util.Objects;

@Data
public class Product {

    @NonNull private int id;
    @NonNull private String name;

    @Override
    public String toString() {
        return "ID-" + id + ": " + name;
    }
}

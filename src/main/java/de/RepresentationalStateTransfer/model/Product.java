package de.RepresentationalStateTransfer.model;

public record Product (int id, String name) {
    @Override public String toString() { return "ID-" + id + ": " + name; }
}

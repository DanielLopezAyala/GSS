package com.example.richslaves;

import javafx.beans.property.*;

public class Products {
    private final IntegerProperty id;
    private final StringProperty name;
    private final IntegerProperty count;
    private final DoubleProperty price;

    public Products() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.count = new SimpleIntegerProperty();
        this.price = new SimpleDoubleProperty();
    }

    // Getters y setters

    public IntegerProperty getId() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public StringProperty getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public IntegerProperty getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(count);
    }

    public DoubleProperty getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }
}
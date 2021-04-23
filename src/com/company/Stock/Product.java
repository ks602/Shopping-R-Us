package com.company.Stock;

public class Product {
    private final SKU sku;
    private final String name;
    private double price;

    public Product(SKU sku, String name, double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public SKU getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }
}
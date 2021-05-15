package com.company.Stock;

import com.company.Precision;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private final SKU sku;
    private final String name;
    private BigDecimal price;

    public Product(SKU sku, String name, String price) {
        this.sku = sku;
        this.name = name;
        this.price = new BigDecimal(price).setScale(Precision.scale, Precision.rMode);
    }

    public SKU getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getPriceString() {
        return price.toPlainString().stripTrailing();
    }

    public void setPrice(double newPrice) {
        price = new BigDecimal(newPrice).setScale(Precision.scale, Precision.rMode);
    }
}
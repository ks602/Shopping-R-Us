package com.company;

import com.company.Stock.Product;
import com.company.Stock.SKU;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private final List<Product> products = new ArrayList<Product>();

    public void addToCart(Product product) {
        products.add(product);
    }

    public List<Product> filterCart(SKU sku) {
        return products.stream().filter(p -> p.getSku() == sku).collect(Collectors.toList());
    }

    public BigDecimal totalAmount() {
        BigDecimal sum = new BigDecimal("0").setScale(Precision.scale, Precision.rMode);
        for (Product product : products)
            sum = sum.add(product.getPrice());
        return sum;
    }
}

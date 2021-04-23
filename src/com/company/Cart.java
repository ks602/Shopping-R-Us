package com.company;

import com.company.Stock.Product;
import com.company.Stock.SKU;

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

    public double totalAmount() {
        double sum = 0;
        for (Product product : products)
            sum += product.getPrice();
        return sum;
    }
}

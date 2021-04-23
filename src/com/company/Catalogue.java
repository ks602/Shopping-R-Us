package com.company;

import com.company.Stock.Product;
import com.company.Stock.SKU;

import java.util.HashMap;
import java.util.Map;

public class Catalogue {
    private HashMap<SKU, Product> productMap = new HashMap<>();

    public void addToCatalogue(Product product) {
        productMap.put(product.getSku(), product);
    }

    public Product getProduct(SKU sku) {
        Product product = productMap.get(sku);
        if (product == null)
            System.out.println("Failed");
        return new Product(product.getSku(), product.getName(), product.getPrice());
    }
}

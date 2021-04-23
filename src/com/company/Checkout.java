package com.company;

import com.company.Stock.Product;
import com.company.Stock.SKU;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkout {

    private final Cart cart = new Cart();
    private Store store;
    private Map<SKU, List<PricingRule>> pricingRules;

    public Checkout(Map<SKU, List<PricingRule>> pricingRules) {
        this.pricingRules = pricingRules;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void scan(SKU sku) throws RuntimeException {
        if (sku == null)
            throw new RuntimeException("Product does not exist");

        Product product = store.getCatalogue().getProduct(sku);
        cart.addToCart(product);

        List<PricingRule> rules = pricingRules.get(sku);
        if (rules != null)
            for (PricingRule rule : rules)
                rule.apply(cart);
    }

    public double total() {
        return cart.totalAmount();
    }
}

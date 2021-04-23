package com.company.Rules;

import com.company.Cart;
import com.company.PricingRule;
import com.company.Stock.Product;
import com.company.Stock.SKU;

import java.util.List;

public class BundlePricingRule implements PricingRule {
    private final SKU bundlePay;
    private final SKU bundleFree;

    public BundlePricingRule(SKU bundlePay, SKU bundleFree) {
        this.bundlePay = bundlePay;
        this.bundleFree = bundleFree;
    }

    @Override
    public void apply(Cart cart) {
        int payCount = cart.filterCart(bundlePay).size();
        List<Product> freeProducts = cart.filterCart(bundleFree);
        
        for (int i = 0; i < payCount; ++i) {
            if (i >= freeProducts.size())
                break;
            freeProducts.get(i).setPrice(0);
        }
    }
}

package com.company.Rules;

import com.company.Cart;
import com.company.PricingRule;
import com.company.Stock.Product;
import com.company.Stock.SKU;

import java.util.List;

public class BulkDiscountPricingRule implements PricingRule {

    private final SKU productSku;
    private final int qty; // need to be more than qty to get discount
    private final double newPrice;


    public BulkDiscountPricingRule(SKU productSku, int qty, double newPrice) {
        this.productSku = productSku;
        this.qty = qty;
        this.newPrice = newPrice;
    }

    @Override
    public void apply(Cart cart) {
        List<Product> products = cart.filterCart(productSku);
        int count = products.size();
        if (count > qty)
            for (Product product : products)
                product.setPrice(newPrice);
    }
}

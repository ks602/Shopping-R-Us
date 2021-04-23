package com.company.Rules;

import com.company.Cart;
import com.company.PricingRule;
import com.company.Stock.Product;
import com.company.Stock.SKU;

import java.util.List;

public class XForYPricingRule implements PricingRule {
    SKU productSKU;
    // for buy 3 pay 2, actualQty = 3, payQty = 2
    private final int actualQty;
    private final int payQty;

    public XForYPricingRule(SKU productSKU, int actualQty, int payQty) {
        this.productSKU = productSKU;
        this.actualQty = actualQty;
        this.payQty = payQty;
    }

    @Override
    public void apply(Cart cart) {
        int count = 0;
        List<Product> productList = cart.filterCart(productSKU);
        int productListSize = productList.size();
        for (int i = productListSize - 1; i >= 0; --i) {
            if (productList.get(i).getPrice() == 0)
                break;
            count++;
        }

        if (count >= actualQty) {
            for (int i = productListSize - 1; i >= productListSize - (actualQty - payQty); --i)
                productList.get(i).setPrice(0);
        }
    }
}

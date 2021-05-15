package com.company;

import com.company.Stock.SKU;

import static com.company.Stock.SKU.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        Store store = new Store();
        Map<SKU, List<PricingRule>> pricingRules;
        pricingRules = store.getPricingRules();
        Checkout co = new Checkout(pricingRules);
        co.setStore(store);

        co.scan(SKU.valueOf("test"));
    }
}

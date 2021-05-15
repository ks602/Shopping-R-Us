package com.company;

import com.company.Rules.BulkDiscountPricingRule;
import com.company.Rules.BundlePricingRule;
import com.company.Rules.XForYPricingRule;
import com.company.Stock.Product;
import com.company.Stock.SKU;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    private final Catalogue catalogue = new Catalogue();
    private final Map<SKU, List<PricingRule>> pricingRules = new HashMap<>();

    public Store() {
        catalogue.addToCatalogue(new Product(SKU.IPD, "Super iPad", "549.99"));
        catalogue.addToCatalogue(new Product(SKU.MBP, "MacBook Pro", "1399.99"));
        catalogue.addToCatalogue(new Product(SKU.ATV, "Apple TV", "109.50"));
        catalogue.addToCatalogue(new Product(SKU.VGA, "VGA Adapter", "30.00"));

        List<PricingRule> ATVRules = new ArrayList<>();
        ATVRules.add(new XForYPricingRule(SKU.ATV, 3, 2));

        List<PricingRule> IPDRules = new ArrayList<>();
        IPDRules.add(new BulkDiscountPricingRule(SKU.IPD, 4, 499.99));

        List<PricingRule> VGAMBPRules = new ArrayList<>();
        VGAMBPRules.add(new BundlePricingRule(SKU.MBP, SKU.VGA));

        pricingRules.put(SKU.ATV, ATVRules);
        pricingRules.put(SKU.IPD, IPDRules);
        pricingRules.put(SKU.VGA, VGAMBPRules);
        pricingRules.put(SKU.MBP, VGAMBPRules);
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public Map<SKU, List<PricingRule>> getPricingRules() {
        return pricingRules;
    }
}

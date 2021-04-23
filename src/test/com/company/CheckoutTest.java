package com.company;

import com.company.Stock.SKU;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest {
    private static Store store;
    private static Map<SKU, List<PricingRule>> pricingRules;

    @BeforeAll
    static void setUp() {
        store = new Store();
        pricingRules = store.getPricingRules();
    }

    @Test
    public void ATVXForYTest() {
        Checkout co = new Checkout(pricingRules);
        co.setStore(store);

        co.scan(SKU.ATV);
        co.scan(SKU.ATV);
        co.scan(SKU.ATV);
        co.scan(SKU.VGA);

        double totalPrice = co.total();

        assertEquals(totalPrice, 249.0);
    }

    @Test
    public void IPDBulkTest() {
        Checkout co = new Checkout(pricingRules);
        co.setStore(store);

        co.scan(SKU.ATV);
        co.scan(SKU.IPD);
        co.scan(SKU.IPD);
        co.scan(SKU.ATV);
        co.scan(SKU.IPD);
        co.scan(SKU.IPD);
        co.scan(SKU.IPD);

        double totalPrice = co.total();

        assertEquals(totalPrice, 2718.95);
    }

    @Test
    public void MBPVGABundleTest() {
        Checkout co = new Checkout(pricingRules);
        co.setStore(store);

        co.scan(SKU.MBP);
        co.scan(SKU.VGA);
        co.scan(SKU.IPD);

        double totalPrice = co.total();

        assertEquals(totalPrice, 1949.98);
    }

    @Test
    public void VGAMBPBundleTest() {
        Checkout co = new Checkout(pricingRules);
        co.setStore(store);

        co.scan(SKU.VGA);
        co.scan(SKU.MBP);
        co.scan(SKU.IPD);

        double totalPrice = co.total();

        assertEquals(totalPrice, 1949.98);
    }
}
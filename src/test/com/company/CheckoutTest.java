package com.company;

import com.company.Stock.SKU;

import static com.company.Stock.SKU.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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

        co.scan(ATV);
        co.scan(ATV);
        co.scan(ATV);
        co.scan(VGA);

        BigDecimal totalPrice = co.total();
        BigDecimal correctSum = new BigDecimal("249.0").setScale(Precision.scale, Precision.rMode);

        assertEquals(correctSum, totalPrice);
    }

    @Test
    public void IPDBulkTest() {
        Checkout co = new Checkout(pricingRules);
        co.setStore(store);

        co.scan(ATV);
        co.scan(IPD);
        co.scan(IPD);
        co.scan(ATV);
        co.scan(IPD);
        co.scan(IPD);
        co.scan(IPD);

        BigDecimal totalPrice = co.total();
        BigDecimal correctSum = new BigDecimal("2718.95").setScale(Precision.scale, Precision.rMode);

        assertEquals(correctSum, totalPrice);
    }

    @Test
    public void MBPVGABundleTest() {
        Checkout co = new Checkout(pricingRules);
        co.setStore(store);

        co.scan(MBP);
        co.scan(VGA);
        co.scan(IPD);

        BigDecimal totalPrice = co.total();
        BigDecimal correctSum = new BigDecimal("1949.98").setScale(Precision.scale, Precision.rMode);

        assertEquals(correctSum, totalPrice);
    }

    @Test
    public void VGAMBPBundleTest() {
        Checkout co = new Checkout(pricingRules);
        co.setStore(store);

        co.scan(VGA);
        co.scan(MBP);
        co.scan(IPD);

        BigDecimal totalPrice = co.total();
        BigDecimal correctSum = new BigDecimal("1949.98").setScale(Precision.scale, Precision.rMode);

        assertEquals(correctSum, totalPrice);
    }

    @Test
    public void PrecisionTest() {
        Checkout co = new Checkout(pricingRules);
        co.setStore(store);

        for (int i = 0; i < 9999; ++i)
            co.scan(IPD);

        BigDecimal totalPrice = co.total();
        BigDecimal correctSum = new BigDecimal("4999400.01").setScale(Precision.scale, Precision.rMode);

        assertEquals(correctSum, totalPrice);
    }
}
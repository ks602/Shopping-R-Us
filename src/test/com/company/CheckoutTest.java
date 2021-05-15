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
    private static Checkout co;

    @BeforeAll
    static void setUp() {
        store = new Store();
        pricingRules = store.getPricingRules();
    }

    @BeforeEach
    void setCo() {
        co = new Checkout(pricingRules);
        co.setStore(store);
    }

    @Test
    public void ATVXForYTest() {
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
        co.scan(MBP);
        co.scan(VGA);
        co.scan(IPD);

        BigDecimal totalPrice = co.total();
        BigDecimal correctSum = new BigDecimal("1949.98").setScale(Precision.scale, Precision.rMode);

        assertEquals(correctSum, totalPrice);
    }

    @Test
    public void VGAMBPBundleTest() {
        co.scan(VGA);
        co.scan(MBP);
        co.scan(IPD);

        BigDecimal totalPrice = co.total();
        BigDecimal correctSum = new BigDecimal("1949.98").setScale(Precision.scale, Precision.rMode);

        assertEquals(correctSum, totalPrice);
    }

    @Test
    public void PrecisionTest() {
        for (int i = 0; i < 9999; ++i)
            co.scan(IPD);

        BigDecimal totalPrice = co.total();
        BigDecimal correctSum = new BigDecimal("4999400.01").setScale(Precision.scale, Precision.rMode);

        assertEquals(correctSum, totalPrice);
    }

    @Test
    public void NullSKUTest() {
        assertThrows(RuntimeException.class, () -> {
            co.scan(null);
        });
    }
}
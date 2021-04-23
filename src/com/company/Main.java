package com.company;

import com.company.Stock.SKU;

public class Main {


    public static void main(String[] args) {
        Store store = new Store();
        Checkout co = new Checkout(store.getPricingRules());
        co.setStore(store);

        co.scan(SKU.VGA);
        co.scan(SKU.MBP);
        co.scan(SKU.IPD);
        double totalPrice = co.total();
        System.out.println(totalPrice);
    }
}

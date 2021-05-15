package com.company;

import com.company.Stock.SKU;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {


    public static void main(String[] args) {
        double sum = 0;
        for (int i = 0; i < 9999; ++i)
            sum += 499.99;
        System.out.println(sum);
    }
}

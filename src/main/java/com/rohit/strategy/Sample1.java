package com.rohit.strategy;

import java.util.List;

public class Sample1 {

    private static int totalValue(List<Integer> values) {
        int total=0;
        for (var value : values) {
            total+=value;
        }
        return total;
    }
    private static int totalValueEven(List<Integer> values) {
        int total=0;
        for (var value : values) {
            if (value %2 == 0) {
                total+=value;
            }
        }
        return total;
    }
    private static int totalValueOdd(List<Integer> values) {
        int total=0;
        for (var value : values) {
            if (value %2 != 0) {
                total+=value;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        List<Integer> values = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(totalValue(values));
        System.out.println(totalValueEven(values));
        System.out.println(totalValueOdd(values));
    }

}
/*
Suppose we have a collection of numbers, may be
price of stock, products, etc.

We are asked to write a method to total all values
*/
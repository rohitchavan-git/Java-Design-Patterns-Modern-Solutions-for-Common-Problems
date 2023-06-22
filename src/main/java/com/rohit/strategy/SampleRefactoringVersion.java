package com.rohit.strategy;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SampleRefactoringVersion {

    private static int totalValue(List<Integer> values,
                                  Predicate<Integer> strategy) {
        return values.stream()
                .filter(strategy)
                .mapToInt(value -> value).sum();
    }

    public static void main(String[] args) {


        List<Integer> values = List.of(1,2,3,4,5,6,7,8,9,10);

        System.out.println(totalValue(values,number -> true));
        System.out.println(totalValue(values,number -> number %2 ==0));
        System.out.println(totalValue(values,number -> number % 2 == 1));


    }
}

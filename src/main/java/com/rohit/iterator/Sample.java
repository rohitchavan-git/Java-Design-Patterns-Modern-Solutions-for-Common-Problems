package com.rohit.iterator;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<String> names = List.of("rohit", "urmila", "rahul", "ram", "sham");
        var result= new ArrayList<>();
        for (String name : names) {
            if (name.length() >4) {
                result.add(name.toUpperCase());
            }
        }
        System.out.println(result);

        var result1= new ArrayList<>();
        names.stream()
                .filter(name->name.length() > 4)
                //.map(name -> performImpureOperation(name)) //avoid
                .map(String::toUpperCase)
                .forEach(result1::add); //BAD IDEA
        //.toList(); is a better option
        //The functional pipeline is *not* pure
        //We are doing shared mutability The result may be unpredictable if we every change this code to run in parallel
        //by adding .parallel() or by changing .stream() to .parallelStream()
        System.out.println(result1);

        //I quit saying "code works"
        //I often now say "the code behaves"

    }

}
//Functional pipeline offers internal iterators
//is less complex
//easy to modify
//easy to understand
//but....

//It is very important that we make the functional
//pipeline pure. Avoid shared mutable variables.

//What is a pure function:
//A pure function is idempotent, it returns the same
//result for the same input and does not have any side effects
//1. It does not change any state that is visible outside
//2. It does not depend on anything outside that may be possibly change

//Functional programming relies on lazy evaluation
//for efficiency.
//Lazy evaluation and parallel execution rely on
//immutability and purify of functions for correctness.

//FP emphasizes immutability and purity, not because
//it is fashionable, but because it is essential to
//it survival.

package com.rohit.lazy.lazy_evaluation_lambda;

import java.util.function.Supplier;

class Lazy<T>{
    private T instance;
    private final Supplier<T> supplier;

    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public T get() {
        if (instance == null) {
            instance= supplier.get();
        }
        return instance;
    }
}

public class Sample {

    public static void main(String[] args) {
        int value = 4;
        Lazy<Integer> lazy = new Lazy<>(()->compute(value));

        if(value > 4 && lazy.get() > 100) {
            System.out.println("path 1");
        }else{
            System.out.println("path 2");
        }
    }

    private static int compute(int value) {
        System.out.println("call compute");
        return value * 100;
    }

}
/*
David Wheeler:
In CS we can solve almost any problem by introducing
one more level of indirection

In procedural code, pointers given the power of indirection
In OO code, overriding functions given the power of indirection
In FP, lambdas give the power of indirection


  myFunction1(Type value) - eager
  myFunction2(Supplier<Type> supplier) - lazy

  When do we pass value vs. a functional interface to
  a method?
  Callbacks: If you want a method to execute a specific action after completing its task,
    you can pass a functional interface that defines the action as a callback.
  Customized behavior: If you want to parameterize a method with different behaviors,
    you can pass different implementations of a functional interface to achieve the desired behavior.
  Functional programming: If you are following functional programming principles and
    want to use higher-order functions, passing functional interfaces allows you to achieve composition and reuse of behavior.

*/
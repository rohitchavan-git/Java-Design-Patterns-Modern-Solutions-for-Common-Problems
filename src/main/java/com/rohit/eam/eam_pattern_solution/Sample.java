package com.rohit.eam.eam_pattern_solution;

import java.util.function.Consumer;

class Resource {
    private Resource() { System.out.println("created..."); }
    public Resource op1() {
        System.out.println("op1...");
        return this;
    }
    public Resource op2() {
        System.out.println("op2...");
        return this;
    }
    private void close() {
        System.out.println("release extenal resource");
    }

    public static void use(Consumer<Resource> block) {
        Resource resource = new Resource(); //before

        try {
            block.accept(resource);
        } finally {
            resource.close(); //after
        }
    }
}

//Exectute Around Method: with a before and after part.
//This is more of a civilized AOP

public class Sample {
    public static void main(String[] args) {
        Resource.use(resource ->
                resource.op1()
                        .op2());
    }
}

package com.rohit.eam.not_a_good_solution;

class Resource{
    public Resource(){
        System.out.println("created ...");
    }
    public void op1(){
        System.out.println("op1 ...");
    }
    public void op2(){
        System.out.println("op2 ...");
    }

    public void close(){
        System.out.println("clean up resource");
    }
}
public class Sample {

    public static void main(String[] args) {
        Resource r = new Resource();
        r.op1();
        r.op2();
        r.close();
    }
}

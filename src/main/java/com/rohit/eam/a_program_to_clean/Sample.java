package com.rohit.eam.a_program_to_clean;

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

    protected void finalize(){
        System.out.println("clean up resource");
    }
}
public class Sample {

    public static void main(String[] args) {
        Resource r = new Resource();
        r.op1();
        r.op2();
        System.gc();
        //finalize not called
     //   r.finalize();
    }
}

package com.rohit.eam.arm_solution;

class Resource implements AutoCloseable{
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

        try (Resource resource = new Resource()) {
            resource.op1();
            resource.op2();
        }
        // resource.close();

        // this program also works without warnings if you don't surround inside try with resource
        // in that case close method not getting called


    }


}

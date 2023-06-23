package com.rohit.Fluency.chaining;

class Mailer{
    public Mailer from(String addr){System.out.println("from..."); return this;}
    public Mailer to(String addr){System.out.println("to..."); return this;}
    public Mailer subject(String subject){System.out.println("subject..."); return this;}
    public Mailer body(String body){System.out.println("body..."); return this;}
    public Mailer send(){System.out.println("send..."); return this;}
}
public class Sample {
    public static void main(String[] args) {
    new Mailer()
        .from("anpch@example.com")
        .to("anpch@example.com")
        .subject("test")
        .body("test")
        .send();
    }
}
//Cascade method pattern


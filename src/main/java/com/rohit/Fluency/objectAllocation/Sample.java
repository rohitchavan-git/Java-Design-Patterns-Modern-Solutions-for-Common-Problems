package com.rohit.Fluency.objectAllocation;

import java.util.function.Consumer;

class Mailer{
    public Mailer from(String addr){System.out.println("from..."); return this;}
    public Mailer to(String addr){System.out.println("to..."); return this;}
    public Mailer subject(String subject){System.out.println("subject..."); return this;}
    public Mailer body(String body){System.out.println("body..."); return this;}
    public static void send(Consumer<Mailer> mailerConsumer) {
        mailerConsumer.accept(new Mailer());
        System.out.println("send...");
    }
}
public class Sample {
    public static void main(String[] args) {
        Mailer.send(mailer->
        new Mailer()
                .from("anpch@example.com")
                .to("anpch@example.com")
                .subject("test")
                .body("test"));
    }
}
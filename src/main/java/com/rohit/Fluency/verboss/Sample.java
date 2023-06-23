package com.rohit.Fluency.verboss;

class Mailer{
    public void from(String addr){System.out.println("from...");}
    public void to(String addr){System.out.println("to...");}
    public void subject(String subject){System.out.println("subject...");}
    public void body(String body){System.out.println("body...");}
    public void send(){System.out.println("send...");}
}
public class Sample {
    public static void main(String[] args) {
        Mailer mailer = new Mailer();
        mailer.from("anpch@example.com");
        mailer.to("anpch@example.com");
        mailer.subject("test");
        mailer.body("test");
        mailer.send();
    }
}

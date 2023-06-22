package com.rohit.lazy.lazy_evaluation;
interface Pet{}
class Dog implements Pet{}
class Cat implements Pet{}
interface Person {
    Pet getPet();
    default void play(){
        System.out.println("playing with " + getPet());
    }
}
class DogPerson implements Person{
    private final Dog dog=new Dog();
    public Pet getPet() {
        return dog;
    }
}
class CatLover implements Person{
    private final Cat cat=new Cat();
    public Pet getPet() {
        return cat;
    }
}
public class Sample {

    private static void call(Person person){
        person.play();
    }
    public static void main(String[] args) {
        call(new DogPerson());
        call(new CatLover());
    }
}

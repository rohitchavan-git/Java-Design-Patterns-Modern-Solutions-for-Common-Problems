package com.rohit.factory.interface_default_as_factory;
interface Pet{}
class Cat implements Pet{}
class Dog implements Pet{}
interface Person{
    Pet getPet();
    default void play(){
        System.out.println("playing with " + getPet());
    }
}
class DogLover implements Person{
    private static final Dog DOG = new Dog();
    @Override
    public Pet getPet() {
        return DOG;
    }
}
class CatLover implements Person{
    private static final Cat CAT = new Cat();
    @Override
    public Pet getPet() {
        return CAT;
    }
}
public class Sample {
    public static void call(Person person){
        person.play();
    }
    public static void main(String[] args) {
        call(new CatLover());
        call(new DogLover());
    }
}

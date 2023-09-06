package firstTask;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog("Bobik"), new Dog("Sharik"), new Dog("Polkan"), new Dog("Jerry")};
        Cat[] cats = {new Cat("Murzik"), new Cat("Vaska"), new Cat("Red"), new Cat("bloom")};

        System.out.println();

        System.out.println(Cat.getCatsCounter());
        System.out.println(Dog.getDogsCounter());

    }
}

package firstTask;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog("Bobik"), new Dog("Sharik"), new Dog("Polkan"), new Dog("Jerry")};
        Cat[] cats = {new Cat("Murzik", 30), new Cat("Vaska", 30), new Cat("Red", 30), new Cat("bloom", 30)};

        Arrays.stream(dogs).forEach(s -> s.run((int) ((Math.random() * 1000) - (Math.random() * 1000))));
        Arrays.stream(dogs).forEach(s -> s.swim((int) ((Math.random() * 20) - (Math.random() * 20))));
        Arrays.stream(cats).forEach(s -> s.run((int) ((Math.random() * 1000) - (Math.random() * 1000))));
        Arrays.stream(cats).forEach(s -> s.swim((int) ((Math.random() * 20) - (Math.random() * 20))));
        System.out.println();

        PlateOfFood plateOfFood = new PlateOfFood(100);

        Arrays.stream(cats).forEach(s -> s.eat(plateOfFood));
        Arrays.stream(cats).forEach(s -> System.out.println(s.satiety()));

        System.out.println(Cat.getCatsCounter());
        System.out.println(Dog.getDogsCounter());

    }
}

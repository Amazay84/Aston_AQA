package firstTask;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog("Bobik"),
                new Dog("Sharik"),
                new Dog("Polkan"),
                new Dog("Jerry")};
        Cat[] cats = {new Cat("Murzik", 30),
                new Cat("Vaska", 30),
                new Cat("Red", 30),
                new Cat("bloom", 30)};

        Arrays.stream(dogs).
                forEach(s -> s.run((int) ((Math.random() * 1000) - (Math.random() * 900))));
        Arrays.stream(dogs).
                forEach(s -> s.swim((int) ((Math.random() * 100) - (Math.random() * 90))));
        Arrays.stream(cats).
                forEach(s -> s.run((int) ((Math.random() * 1000) - (Math.random() * 900))));
        Arrays.stream(cats).
                forEach(s -> s.swim((int) ((Math.random() * 20) - (Math.random() * 18))));
        System.out.println();

        PlateOfFood plateOfFood = new PlateOfFood(100);

        Arrays.stream(cats).
                forEach(s -> s.eat(plateOfFood));
        Arrays.stream(cats).
                forEach(s -> System.out.println(s.satiety()));

        System.out.println("Всего котов: " + Cat.getCatsCounter());
        System.out.println("Всего собак: " + Dog.getDogsCounter());

    }
}

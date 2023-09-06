package firstTask;

public class Main {
    public static void main(String[] args) {
        Dog bobik = new Dog("Bobik");
        Cat murzik = new Cat("Murzik");
        Dog sharik = new Dog("Sharik");
        Cat vaska = new Cat("Vaska");
        Dog polkan = new Dog("Polkan");
        Cat red = new Cat("Red");
        Dog jerry = new Dog("Jerry");
        Cat bloom = new Cat("bloom");


        bobik.run(499);
        bobik.swim(9);
        murzik.run(199);
        murzik.swim(11);
        sharik.run(501);
        sharik.swim(11);
        vaska.run(201);
        vaska.swim(0);
        polkan.run(-1);
        polkan.swim(-1);
        red.run(-1);
        red.swim(-1);
        jerry.run(500);
        jerry.swim(10);
        bloom.run(200);
        bloom.swim(9);

        System.out.println();

        System.out.println(Cat.getCatsCounter());
        System.out.println(Dog.getDogsCounter());

    }
}

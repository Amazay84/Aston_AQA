import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Apple> appleBox = new Box<>(new ArrayList<>(Arrays.asList(apple1, apple2, apple3)));
        Box<Orange> orangeBox = new Box<>(new ArrayList<>(Arrays.asList(orange1, orange2, orange3)));
        System.out.printf("Равны ли коробки по весу? | %b\n", appleBox.compare(orangeBox));
        System.out.println("---------------------------------------");

        Box<Apple> appleBoxReserved= new Box<>(new ArrayList<>());
        System.out.println("Вес 1й коробки яблок до пересыпки во 2ю - " + appleBox.getWeight());
        appleBox.intersperseToAnotherBox(appleBoxReserved);
        System.out.println("Вес 1й коробки яблок после пересыпки во 2ю - " + appleBox.getWeight());
        System.out.println("Вес 2й коробки яблок после пересыпки из 1й - " + appleBoxReserved.getWeight());
        System.out.println(orangeBox);
        orangeBox.addFruit(new Orange());
        System.out.println(orangeBox);
        orangeBox.getFruits().
                stream().
                forEach(System.out::println);
    }
}

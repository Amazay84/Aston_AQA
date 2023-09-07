package secondTask;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4.0f, 9.0f, "Желтый", "Зеленый");
        Circle circle = new Circle(6.6f, "Крассный", "Желтый");
        TriAngle triAngle = new TriAngle(5f, 7f, 6f, "Синий", "Оранжевый");
        System.out.println(rectangle);
        System.out.println(circle);
        System.out.println(triAngle);
    }
}

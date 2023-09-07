package secondTask;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends AbstractFigure {
    private float sideA;
    private float sideB;

    public Rectangle(float sideA, float sideB, String borderColor, String filingColor) {
        super(borderColor, filingColor);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public float calculateSquare() {
        return sideA * sideB;
    }

    @Override
    public String toString() {
        return "Rectangle [" +
                "Периметр = " + super.calculateRectanglePerimeter(sideA, sideB) +
                super.toString();
    }

}

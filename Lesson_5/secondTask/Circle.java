package secondTask;

public class Circle extends AbstractFigure {
    private float radius;

    public Circle(float radius, String borderColor, String filingColor) {
        super(borderColor, filingColor);
        this.radius = radius;
    }

    @Override
    public float calculateSquare() {
        return (float) Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle [" +
                "Периметр = " + super.calculateCirclePerimeter(radius) +
                super.toString();
    }
}

package secondTask;

public class Circle implements CalculateSquare, CalculatePerimeter {
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public float calculatePerimeter() {
        return (float) Math.PI * radius * 2;
    }

    @Override
    public float calculateSquare() {
        return (float) Math.PI * radius * radius;
    }
}

package secondTask;

public class Rectangle implements CalculatePerimeter, CalculateSquare{
    private float sideA;
    private float sideB;

    public Rectangle(float sideA, float sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public float calculatePerimeter() {
        return sideA + sideB;
    }

    @Override
    public float calculateSquare() {
        return sideA * sideB;
    }
}

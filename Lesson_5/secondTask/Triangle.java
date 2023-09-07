package secondTask;

public class Triangle extends AbstractFigure {
    private float sideA;
    private float sideB;
    private float sideC;

    public Triangle(float sideA, float sideB, float sideC, String borderColor, String filingColor) {
        super(borderColor, filingColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public float calculateSquare() {
        float halfPerimeter = calculateTrianglePerimeter(sideA, sideB, sideC) / 2;
        return (float) Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideC) * (halfPerimeter -sideB));
    }

    @Override
    public String toString() {
        return "Triangle [" +
                "Периметр = " + super.calculateTrianglePerimeter(sideA, sideB, sideC) +
                super.toString();
    }

}

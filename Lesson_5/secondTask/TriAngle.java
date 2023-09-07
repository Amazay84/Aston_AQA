package secondTask;

public class TriAngle extends AbstractFigure {
    private float sideA;
    private float sideB;
    private float sideC;

    public TriAngle(float sideA, float sideB, float sideC, String borderColor, String filingColor) {
        super(borderColor, filingColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public float calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public float calculateSquare() {
        float halfPerimeter = calculatePerimeter() / 2;
        return (float) Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideC) * (halfPerimeter -sideB));
    }

}

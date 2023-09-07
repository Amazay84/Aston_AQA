package secondTask;

public interface Calculate {
    float calculateSquare();
    default float calculateCirclePerimeter(float radius) {
        return (float) Math.PI * radius * 2;
    }

    default float calculateRectanglePerimeter(float sideA, float sideB) {
        return sideA * 2 + sideB * 2;
    }

    default float calculateTrianglePerimeter(float sideA, float sideB, float sideC) {
        return sideA + sideB + sideC;
    }

}

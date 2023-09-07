package secondTask;

public abstract class AbstractFigure implements CalculateSquare, CalculatePerimeter {
    private String borderColor;
    private String filingColor;

    public AbstractFigure(String borderColor, String filingColor) {
        this.borderColor = borderColor;
        this.filingColor = filingColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public String getFilingColor() {
        return filingColor;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" +
                "Периметр = " + calculatePerimeter() +
                ", Площадь = " + calculateSquare() +
                ", Цвет границ = " + getBorderColor() +
                ", Цвет фона = " + getFilingColor() + ']';
    }

}

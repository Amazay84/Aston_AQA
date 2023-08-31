package PrintColor;

public class PrintColor {
    private int value;

    public PrintColor() {
        this.value = (int) (((Math.random() * 1000) - (Math.random() * 1000)));
    }

    public PrintColor(int value) {
        this.value = value;
    }
    public void printColor() {
        if (value <= 0) System.out.println("Красный!");
        else if (value > 0 && value <= 100) System.out.println("Желтый!");
        else if (value > 100) System.out.println("Зеленый!");
    }
}

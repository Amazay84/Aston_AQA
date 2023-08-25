package CompareNumbers;

public class CompareNumbers {
    private int a;
    private int b;

    public CompareNumbers() {
        this.a = (int) Math.random() * 10;
        this.b = (int) Math.random() * 10;
    }

    public void compareNumbers() {
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
}

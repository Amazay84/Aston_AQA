package CheckSumSign;

import java.util.Scanner;

public class CheckSumSign {
    private int a;
    private int b;

    public CheckSumSign() {
        System.out.println("Input first number.");
        this.a = new Scanner(System.in).nextInt();
        System.out.println("Input second number.");
        this.b = new Scanner(System.in).nextInt();
    }
    public void checkSumSign() {
        if ((this.a + this.b) >= 0) System.out.println("Сумма положительная!");
        else System.out.println("Сумма отрицательная");
    }


}

import PrintThreeWords.PrintThreeWords;
import CompareNumbers.CompareNumbers;
import CheckSumSign.CheckSumSign;
import PrintColor.PrintColor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrintThreeWords print = new PrintThreeWords();
        print.printThreeWords();
        System.out.println("------------------------------------------------------------------------------------------");

        CheckSumSign checkSumSign = new CheckSumSign();
        checkSumSign.checkSumSign();
        System.out.println("------------------------------------------------------------------------------------------");

        PrintColor printColor = new PrintColor();
        System.out.print("Тут у нас псевдорандом...-> ");
        printColor.printColor();

        System.out.println("Введите произвольное отрицательное или положительное число!");
        int value = new Scanner(System.in).nextInt();
        PrintColor printColor1 = new PrintColor(value);
        System.out.print("То, что мы ввели...-> ");
        printColor1.printColor();
        System.out.println("------------------------------------------------------------------------------------------");

        CompareNumbers compareNumbers = new CompareNumbers();
        compareNumbers.compareNumbers();

    }
}

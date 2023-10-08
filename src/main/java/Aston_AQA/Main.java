package Aston_AQA;

public class Main {
    private static String labelWithText(String text) {
        return "//label[text()=".concat("'").concat(text).concat("'").concat("]");
    }

    public static void main(String[] args) {
        System.out.println(Main.labelWithText("Номер карты"));
    }
}
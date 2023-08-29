public class Methods {
    public static boolean isSumAtBorders(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    public static void numberSignDetector(int a) {
        String detectedSign = a >= 0 ? "number ".concat(String.valueOf(a)).concat(" is positive!"):
                "number ".concat(String.valueOf(a)).concat(" is negative!");
        System.out.println(detectedSign);
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPositiveOrNegative(int a) {
        return a < 0;
    }



    public static void stringPrinter(String s, int a) {
        for (int i = 0; i <= a; i++) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        System.out.println(Methods.isSumAtBorders(11, 9));
        Methods.numberSignDetector(0);
        System.out.println(Methods.isPositiveOrNegative(0));
        Methods.stringPrinter("Hello", 4);
        System.out.println(Methods.isLeapYear(300));
    }
}

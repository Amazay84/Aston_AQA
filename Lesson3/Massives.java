import java.util.Arrays;

public class Massives {
    private int[][] array;

    public Massives(int[][] array) {
        this.array = array;
    }

    public int[][] getArray() {
        return array;
    }
    public static int[][] massiveCrossFiller(int a, int b) {
        int[][] array = new int[a][b];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if (i == j) {
                    array[i][j] = 1;
                }
                if (array[i].length - 1 - i == j) {
                    array[i][j] = 1;
                }
            }
        }
        return array;
    }

    public static int[] arrayInitializer(int initValue, int length) {
        int[] array = new int[length];
        //Arrays.fill(array, initValue);
        for (int i = 0; i < array.length; i++) {
            array[i] = initValue;
        }
        return array;
    }

    public static void printSingleDimArray(int[] array) {
        Arrays.stream(array).forEach(s -> System.out.print(String.valueOf(s).concat(" ")));
    }

    public static void printTwoDimArray(int[][] array) {
        for (int[] i : array) {
            System.out.println();
            for (int j : i) {
                System.out.print(j);
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {1, 0, 1, 1, 0, 1, 0, 1, 0, 0};
        Massives.printSingleDimArray(array);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0 ? 1 : 0);
        }
        Massives.printSingleDimArray(array);
        System.out.println(System.lineSeparator().concat("_________________________________________________________________"));

        int[] hundred = new int[100];
        for (int i = 0; i < hundred.length; i++) {
            hundred[i] = i + 1;
        }
        Massives.printSingleDimArray(hundred);
        System.out.println(System.lineSeparator().concat("_________________________________________________________________"));

        int[] multipleArray = {1, 5, 3, 11, 2, 4, 5, 2, 4, 8,9, 1};
        Massives.printSingleDimArray(multipleArray);
        System.out.println();
        for (int i = 0; i < multipleArray.length; i++) {
            if (multipleArray[i] < 6) {
                multipleArray[i] = multipleArray[i] * 2;
            }
        }
        Massives.printSingleDimArray(multipleArray);
        System.out.println(System.lineSeparator().concat("_________________________________________________________________"));

        Massives massives = new Massives(massiveCrossFiller(10, 10));
        Massives.printTwoDimArray(massives.getArray());
        System.out.println(System.lineSeparator().concat("_________________________________________________________________"));

        Massives.printSingleDimArray(Massives.arrayInitializer(9, 5));
    }
}

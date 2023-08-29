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
        Arrays.stream(array).forEach(System.out::print);
    }

    public static void printTwoDimArray(int[][] array) {
        for (int[] ints : array) {
            System.out.println();
            for (int anInt : ints) {
                System.out.print(anInt);
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {1, 0, 1, 1, 0, 1, 0, 1, 0, 0};
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0 ? 1 : 0);
        }
        Massives.printSingleDimArray(array);
        System.out.println();

        int[] hundred = new int[100];
        for (int i = 0; i < hundred.length; i++) {
            hundred[i] = i + 1;
        }
        Arrays.stream(hundred).forEach((s) -> System.out.print(String.valueOf(s).concat(" ")));
        System.out.println();

        Massives massives = new Massives(massiveCrossFiller(10, 10));
        Massives.printTwoDimArray(massives.getArray());
        System.out.println();

        Massives.printSingleDimArray(Massives.arrayInitializer(9, 5));
    }
}

import java.util.Arrays;

public class Main {

    public static int myExceptionHandler(String [][] array)
            throws MyArraySizeException, MyArrayDataException{
        int summ = 0;
        if (array.length != 4) {
            throw new MyArraySizeException("Rows count is different then 4.");
        }
        for (int i = 0 ; i < array.length; i++) {
            if (array[i].length !=4) {
                throw new MyArraySizeException(String.format("Cells count at row %d is different then 4.", i));
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    summ += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("Data at row[%d] cell[%d] don't contains number.", i, j));
                }
            }
        }
        return summ;
    }
    public static void main(String[] args) {
        String[][] correct = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"}};
        String[][] incorrectRows = {{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"1", "2", "3", "4"}};
        String[][] incorrectCellAtRows = {{"1", "2", "3", "4"},
                {"5", "6", "7"},
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"}};
        String[][] incorrectData = {{"1", "2", "3", "4"},
                {"5", "6", "7", "Java"},
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"}};

        try {
            Main.myExceptionHandler(incorrectRows);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------------------------------------------------");

        try {
            Main.myExceptionHandler(incorrectCellAtRows);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------------------------------------------------");

        try {
            Main.myExceptionHandler(incorrectData);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------------------------------------------------");

        try {
            System.out.println("Arrays data summary is: ".
                    concat(String.valueOf(Main.myExceptionHandler(correct))));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }
}

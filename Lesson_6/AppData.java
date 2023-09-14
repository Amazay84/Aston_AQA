import com.sun.net.httpserver.Headers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class AppData {
    private static String[] header;
    private static int[][] data;

    public AppData(String[] header, int[][] data) {
        AppData.header = header;
        AppData.data = data;
    }

    public static String[] getHeader() {
        return header;
    }

    public static int[][] getData() {
        return data;
    }

    //преобразование таблицы в массивы
    public static AppData getAppData(File file) throws IOException {

        StringBuilder sb = new StringBuilder();
        String headersString = "";
        String dataString = "";
        byte[] buffer = new byte[30];
        int count;

        try (FileInputStream fis = new FileInputStream(file)) {
            while ((count = fis.read(buffer)) > 0) {
                for (int i = 0; i < count; i++) {
                    sb.append((char) buffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        headersString = sb.substring(0, sb.indexOf(System.lineSeparator()));
        dataString = sb.substring(sb.indexOf(System.lineSeparator()));
        String[] header = headersString.trim().split(";,");

        String[] dataTemp = dataString.trim().split(System.lineSeparator());
        int[][] data = new int[dataTemp.length][header.length];

        for (int i = 0; i < data.length; i++) {
            String[] temp = dataTemp[i].split(";,");
            int[] intTemp = new int[temp.length];
            for (int j = 0; j < data[i].length; j++) {
                intTemp[j] = Integer.parseInt(temp[j]);
            }
            data[i] = Arrays.copyOf(intTemp, intTemp.length);
        }
        return new AppData(header, data);
    }

    //преобразование массивов в таблицу
    public static String saveAppData(AppData appData) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < header.length; i++) {
            sb.append(header[i]);
            if (i < header.length - 1) {
                sb.append(";,");
            } else {
                sb.append(System.lineSeparator());
            }
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sb.append(data[i][j]);
                if (j < header.length - 1) {
                    sb.append(";,");
                } else {
                    sb.append(System.lineSeparator());
                }
            }
        }
        byte[] output = sb.toString().trim().getBytes();
        try (FileOutputStream fos = new FileOutputStream("file.csv")) {
            fos.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "AppData:\n" +
                "header = " + Arrays.deepToString(header) +
                "\n" +
                "data = " + Arrays.deepToString(data);
    }
}

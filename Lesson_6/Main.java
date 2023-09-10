import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("file.csv");
        if (file.exists()) {
            file.createNewFile();
        }
        System.out.println(AppData.getAppData(file));
        AppData appData = new AppData(AppData.getHeader(), AppData.getData());
        System.out.println(AppData.saveAppData(appData));
    }
}
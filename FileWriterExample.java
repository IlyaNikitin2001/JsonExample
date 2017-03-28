import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by USER on 26.03.2017.
 */
public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        String s = "html";
        File file = new File("1.html");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(s);
        fileWriter.close();

    }
}

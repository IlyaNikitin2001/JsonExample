import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Scanner;

/**
 * Created by USER on 27.03.2017.
 */
public class SiteExample {
    public static void main(String[] args) throws IOException {
        Document document;
        Scanner scanner = new Scanner(System.in);
       System.out.println("введите имя сайта");
       String url = String.valueOf(scanner.next());
            document = Jsoup.connect(url).get();
            Elements links = document.select("a[href]");

        FileWriter fileWriter = new FileWriter("Site1.html");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("<html>");
        bufferedWriter.newLine();
        bufferedWriter.write("<body>");
        bufferedWriter.newLine();
        bufferedWriter.write("<head></head>");
        for (Element e: links){
            Element s = e.prepend("href");
            bufferedWriter.write(s.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.write("</body>");
        bufferedWriter.newLine();
        bufferedWriter.write("</html>");
        bufferedWriter.close();

    }
}

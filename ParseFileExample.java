import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by USER on 26.03.2017.
 */
public class ParseFileExample {
    public static void main(String[] args) {
        Document document;
        try {
            String url ="https://www.tut.by";
            document = Jsoup.connect(url).get();
            Elements links = document.select("a[href]");
            for (Element link : links) {
                System.out.println(link.text());
            }
            FileWriter fileWriter = new FileWriter("1.html");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("<html>");
            bufferedWriter.newLine();
            bufferedWriter.write("<head><title>tut.by</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>");
            for (Element e: links){
               Element s = e.prepend("href");
                bufferedWriter.write(s.toString());
                bufferedWriter.newLine();
                System.out.println(e);
                }
                bufferedWriter.write("</body>");
                bufferedWriter.newLine();
                bufferedWriter.write("</html>");
                bufferedWriter.close();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
           Elements i = document.select("img");
            for (Element l : i) {
                 l.attr("src");
                System.out.println(l);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
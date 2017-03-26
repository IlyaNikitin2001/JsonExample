import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created by USER on 25.03.2017.
 */
public class ParseFileHTMLExample {
    public static void main(String[] args) {
        try {
            Document document= Jsoup.parse(new File("C:/Users/USER/Desktop/MySite/index.html"),"UTF-8");
            Elements links = document.select("a[href]");

            for (Element e: links){
//            String text = e.attr("href");
//                System.out.println(text);
////                e.prepend("<p>Hello</p>");
               System.out.println(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

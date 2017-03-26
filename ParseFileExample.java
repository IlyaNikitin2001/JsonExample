import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created by USER on 26.03.2017.
 */
public class ParseFileExample {
    public static void main(String[] args) {
        Document document;
        try {
            document = Jsoup.connect("https://www.tut.by").get();
            Elements links = document.select("a[href]");
            for (Element link : links) {
                System.out.println(link.text());
            }

            for (Element e: links){

                e.prepend("href");
                System.out.println(e);


                }
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
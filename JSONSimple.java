/**
 * Created by USER on 19.03.2017.
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.StringTokenizer;

public class JSONSimple {
    public static void main(String[] args) {
        Document document ;
        try {
            document = Jsoup.connect("http://tut.by").get();
            String title = document.title();
            System.out.println(title);
//            достать из документа все ссылки
            Elements links = document.select("a[href]");
//            все элементы списка Links
            for(Element link:links){
//                вывести текст ссылок
//                System.out.println(link.text());
//                System.out.println(link.attr("href"));
//                список элемента из документа с тегом input
                Elements inputElements = document.select("input");
//                из каждого элемента достаем атрибут с именем name
                for(Element input: inputElements ){
                    String name= input.attr("name");
//                    System.out.println(name);

                }
//                достаем из документа спиок элементов с именм news-entry small time ni
                Elements news = document.select(".news-entry small time ni");
                for(Element e: news){
                    String s = e.text();
                    System.out.println(s);
//                    System.out.println(e.text());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

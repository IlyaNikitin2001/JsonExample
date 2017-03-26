import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by USER on 21.03.2017.
 */
public class SimpleJSON {
    public static void main(String[] args) {
        Document document ;
        int count=0;
        int count1=0;
        try {
//            получаем html код со страницы amazone
            document = Jsoup.connect("https://www.amazon.com").get();
//            дотаеим title из страницы amazone
            String title = document.title();
            System.out.println(title);
//            переписываем всче ссылки в массив элементов
            Elements links = document.select("a[href]");
//            переписываем все ссылки из массива
            for(Element link:links){
                System.out.println(link.text());
//                выводим адрес ссылки
                System.out.println(link.attr("href"));
                System.out.println(link.html());
            }
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        Elements elementInput = document.select("input");
//            for(Element element: elementInput){
//
//            String n = element.attr("");
//                System.out.println(n);
//            }
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");



        } catch (IOException e) {
            e.printStackTrace();
        }
        String html = "<html>\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "<title>title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>SiteName</h1>\n" +
                "<img src = \"json_logo-555px.png\" alt= \"Json\">\n" +
                "<a href=\"https://www.tut.by/resource/\" title=\"Artikle\"><img src = \"json_logo-555px.png\" alt= \"Json\"></a>\n" +
                "<br>\n" +
                "<form method = \"GET\">\n" +
                "<input type=\"text\" name = \"login\"  value=\"Login\">\n" +
                "<br>\n" +
                "<input type=\"text\" name = \"mail\"  value=\"Email\">\n" +
                "<br>\n" +
                "<input type=\"text\" name = \"Password\"  value=\"Password\">\n" +
                "<br>\n" +
                "<input type=\"submit\" value=\"OK\"> \n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
        Document doc= Jsoup.parse(html);
//       достать пекрвую ссылку
        Element link = doc.select("a").first();
//        достаем тело из html страницы
        String text = doc.body().text();
//        достаем значение title
        String linkHref = link.attr("title");
//        достаем все inputы
        Elements input = doc.select("input");
        System.out.println(text);
        System.out.println(linkHref);
//        пербираем массив элементов
        for(Element e : input){
//            значение name из тега input
            String s = e.attr("name");
            System.out.println(s);
        }
        System.out.println(link.html());
        Element form = doc.select("form").first();
        System.out.println(form.attr("method"));
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        try {
            document = Jsoup.connect("https://www.tut.by").get();
            Elements links = document.select("a[href]");
            for(Element l:links) {
                System.out.println(l.text());
               count1++;
            }

            System.out.println(count);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Elements i = document.select("img");
           for(Element l:i) {
               String s = l.attr("src");
               System.out.println(l);
               count++;
          }
            System.out.println(count);
            Elements inputElements = document.select("input");
            for(Element in: inputElements ) {
                String name = in.attr("name");
                   System.out.println(name);
            }
            System.out.println(count1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

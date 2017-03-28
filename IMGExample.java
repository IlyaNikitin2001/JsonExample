import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by USER on 28.03.2017.
 */
public class IMGExample {
    public static void main(String[] args) throws IOException {
//        документ
        Document document;
//        эземпляр класса  Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите имя сайта");
        String url = String.valueOf(scanner.next());
//          подключаем к url
        document = Jsoup.connect(url).get();
//        достаем из локумента все картинки
         Elements links = document.select("img[src]");
//         писатель
         FileWriter fileWriter = new FileWriter("1.html");
         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        //       записываем тег html
        bufferedWriter.write("<html>");
         bufferedWriter.newLine();
        //       записываем тег body
        bufferedWriter.write("<body>");
        bufferedWriter.newLine();
//        открывающтй и закрывающий тег head
        bufferedWriter.write("<head></head>");
//     в цикле присваеваем e значение links
        for (Element e: links){
//            добавляем значенние атрибута src
            Element s = e.prepend("src");
//            записываем
            bufferedWriter.write(s.toString());
            bufferedWriter.newLine();
        }
//        закрывающий тег body
        bufferedWriter.write("</body>");
//        новая строка
        bufferedWriter.newLine();
//     закрывающий тег html
        bufferedWriter.write("</html>");
//        закрытие bufferedWriter
        bufferedWriter.close();
    }
}

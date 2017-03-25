import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
/**
 * Created by USER on 18.03.2017.
 */
public class JSONExample {

        public static String parserURL(URL url)  {
//            если url равен null
            if(url==null){
//                то выводит
                return"";
            }
//            экземпляр класса stringbuelder
            StringBuilder buider= new StringBuilder();
//            с помощью bufferReader открываем входящий поток указаннуму url
            try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))){
//                новая переменная
            String inputline;
            while((inputline=in.readLine())!=null){
                buider.append(inputline);
                System.out.println(inputline);

            }

            }
            catch (IOException e){

            }
            return buider.toString();
        }

    }






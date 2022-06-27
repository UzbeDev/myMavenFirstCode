import Yandex.Dictionary;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Translate {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String key = "dict.1.1.20211029T101413Z.7946363a184f9c38.9926779f3d69e1a03d8b8c567e27130ba5261ed8";
        String url = "https://dictionary.yandex.net/api/v1/dicservice.json/getLangs?key=";
        HttpGet httpGet = new HttpGet(url + key);
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpGet);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        Gson gson = new Gson();
        String[] strings = gson.fromJson(reader, String[].class);
        System.out.println("choose language");
        int count = 1;
        for (String string : strings) {
            System.out.println(count + " " + string);
            count++;
        }
        int langIndex = scanner.nextInt();
        String lang = strings[langIndex - 1];
        System.out.println("Tap to enter text");
        String text = scanner.next();
        String trUri = "https://dictionary.yandex.net/api/v1/dicservice.json/loocup?key=";
        httpGet = new HttpGet(trUri + key + "&lang=" + lang + "&text=" + text);
        response = client.execute(httpGet);
        reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        Dictionary dictionary = gson.fromJson(reader, Dictionary.class);
        gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(dictionary);
        System.out.println(s);
    }
}

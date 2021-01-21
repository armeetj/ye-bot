// @author ArmeetJatyani
// kanye.rest REST API Wrapper

package api;

import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class KanyeRestAPIWrapper
{
    /**
     * https://api.kanye.rest
     * @return
     */
    @SneakyThrows
    public static String get()
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.kanye.rest?format=text")
                .build(); // defaults to GET

        Response response = client.newCall(request).execute();
        return response.body().string();


//        return "random quote ;)";
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class HttpRequestExample {

    public static void main(String[] args) throws Exception {

        URL url = new URL(" https://example.com");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {

            response.append(inputLine);

        }

        in.close();

        System.out.println(response.toString());

    }

} 
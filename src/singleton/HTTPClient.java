package src.singleton;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HTTPClient {

    // The single instance of the class
    private static HTTPClient instance = new HTTPClient();

    // Private constructor to prevent instantiation
    private HTTPClient() {}

    // Static method to get the single instance of the class
    public static HTTPClient getInstance() {
        return instance;
    }

    // Method to perform a GET request
    public String sendGetRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Checking the response code
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP GET Request Failed with Error code : " + responseCode);
        }

        // Reading response from input Stream
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        return response.toString();
    }
}

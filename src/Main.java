import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
//import org.json.JSONObject;
import java.net.http.HttpResponse;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter city name: ");
        String cityName = scanner.nextLine();

        scanner.close();

        // Construct the URL with the dynamic city name
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" + cityName + "&count=1&language=en&format=json";

        try {
            // Create a URL object with the constructed URL string
            URL obj = new URL(urlString);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Set the request headers
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Enable writing output (though not necessary for GET requests)
            connection.setDoOutput(true);

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                // Read the response line by line
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Display the response
                System.out.println("Response: " + response.toString());
            } else {
                System.out.println("GET request failed. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    // Helper method to fetch data from the API

}

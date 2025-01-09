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

    // Replace with your Open Exchange Rates API Key

    public static void main(String[] args) {
//        String url = "https://api.openweathermap.org/data/2.5/weather?q=Paris,FR&appid={c5176e92305a818f3f8ddd2e0addb937}\n";
//        String url = "https://geocoding-api.open-meteo.com/v1/search?name=Berlin&count=1&language=en&format=json";

        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a city name
        System.out.print("Enter city name: ");
        String cityName = scanner.nextLine();  // Read the user input

        scanner.close();  // Close the scanner after input is taken

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

            // Request parameters (optional, used in POST requests, not required for this GET request)
//            String parameters = "q=Paris1";  // This is not needed, since it's a GET request
//
//            // Send the parameters (not required for GET, but added for the example)
//            try (OutputStream os = connection.getOutputStream()) {
//                os.write(parameters.getBytes());
//                os.flush();
//            }


            // Get the HTTP response code
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

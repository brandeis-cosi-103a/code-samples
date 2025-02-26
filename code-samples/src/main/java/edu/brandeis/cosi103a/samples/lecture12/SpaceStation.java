package edu.brandeis.cosi103a.samples.lecture12;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpaceStation {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://api.open-notify.org/iss-now.json"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
            }

            String content = response.body();

            // Without a class to parse into - you can traverse the JSON tree directly
            // But this is not a very readable or maintainable approach
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(content.toString());
            JsonNode position = json.get("iss_position");
            String longitude = position.get("longitude").asText();
            String latitude = position.get("latitude").asText();

            // With a class to parse into - you can use the class to access the data
            IssPosition issPosition = mapper.readValue(content.toString(), IssPosition.class);
            System.out.println("Parsed using IssPosition object:");
            System.out.println("Longitude: " + issPosition.getPosition().getLongitude());
            System.out.println("Latitude: " + issPosition.getPosition().getLatitude());

            System.out.println("Current position of the ISS:");
            System.out.println("Longitude: " + longitude);
            System.out.println("Latitude: " + latitude);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

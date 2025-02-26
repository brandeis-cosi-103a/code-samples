package edu.brandeis.cosi103a.samples.lecture12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpaceStation {
    public static void main(String[] args) {
        try {
            URL url = new URI("http://api.open-notify.org/iss-now.json").toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + responseCode);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            // Without a class to parse into - you can traverse the JSON tree directly
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

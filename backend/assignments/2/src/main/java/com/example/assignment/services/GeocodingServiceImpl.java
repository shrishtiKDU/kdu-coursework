package com.example.assignment.services;
import com.example.assignment.constants.Url;
import com.example.assignment.dto.AddressDto;
import com.example.assignment.entity.Coordinates;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



@Service
public class GeocodingServiceImpl implements GeocodingService{
    @Override
    public Coordinates getCoordinatesByAddress(AddressDto addressDto) {
        String apiKey= Url.API_KEY;

        String apiUrl = String.format("https://api.geoapify.com/v1/geocode/search?text=%s&apiKey=%s",
                addressDto, apiKey);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            double longitude = 0;
            double latitude = 0;

            try {
                JsonNode data = objectMapper.readTree(response.body());
                JsonNode features = data.path("features");
                for (JsonNode feature : features) {
                    latitude = feature.path("geometry").path("coordinates").get(1).asDouble();
                    longitude = feature.path("geometry").path("coordinates").get(0).asDouble();
                }
                Coordinates coordinates = new Coordinates(latitude,longitude);
                System.out.println(latitude);
                System.out.println(longitude);
                return coordinates;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
     return null;
    }
}
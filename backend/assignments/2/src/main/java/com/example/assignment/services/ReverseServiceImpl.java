package com.example.assignment.services;

import com.example.assignment.constants.Url;
import com.example.assignment.dto.CoordinatesDto;
import com.example.assignment.entity.Address;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class ReverseServiceImpl implements ReverseService{
    @Override
    public Address getAddressByCoordinates(CoordinatesDto coordinatesDto) {
        Address address = null;
        double lat = coordinatesDto.getLatitude();
        double lon = coordinatesDto.getLongitude();
        String apiKey = Url.API_KEY;  // Replace with your actual API key

        String apiUrl = String.format("https://api.geoapify.com/v1/geocode/reverse?lat=%s&lon=%s&apiKey=%s",
                lat, lon, apiKey);

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse JSON response using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode result = objectMapper.readTree(response.body());

            // Check if features array is not empty
            if (result.has("features") && result.get("features").isArray() && result.get("features").size() > 0) {
                String formattedAddress = result.get("features").get(0).get("properties").get("formatted").asText();
                System.out.println(formattedAddress + "hodufn");
                address.setAddress(formattedAddress);
            } else {
                System.out.println("No address found");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return address;
    }
}

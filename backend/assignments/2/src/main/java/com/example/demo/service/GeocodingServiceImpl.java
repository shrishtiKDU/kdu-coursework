package com.example.demo.service;

import com.example.demo.constant.Url;
import com.example.demo.dto.AddressDto;
import com.example.demo.exceptions.custom.InvalidRequestParam;
import com.example.demo.entity.Coordinates;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import lombok.extern.slf4j.Slf4j;


/**
 * Implementation of the {@link GeocodingService} interface that retrieves geographical coordinates
 * based on the provided address using the Geoapify API.
 */

@Service
@Slf4j
public class GeocodingServiceImpl implements GeocodingService {


    /**
     * Retrieves geographical coordinates based on the provided address.
     *
     * @param addressDto The Data Transfer Object (DTO) representing the address.
     * @return The {@link Coordinates} corresponding to the provided address.
     * @throws InvalidRequestParam If there are issues with the request parameters.
     * @throws RuntimeException    If an unexpected error occurs during the request.
     */

    @Autowired
    private Environment environment;



    @Override
    public Coordinates getCoordinatesByAddress(AddressDto addressDto) {

        Coordinates coordinates = new Coordinates();
        String apiKey = environment.getProperty("api-key");

        String apiUrl = String.format(Url.GEOCODE_API,
                addressDto.getAddress(), apiKey);

        log.info("address recieved : " + addressDto.getAddress());
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .build();
        try {
            coordinates = mapCoordinates(client, request);

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return coordinates;
    }


    public Coordinates mapCoordinates(HttpClient client, HttpRequest request) {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            double longitude = 0;
            double latitude = 0;
            JsonNode data = objectMapper.readTree(response.body());
            JsonNode features = data.path("features");
            latitude = features.get(0).path("geometry").path("coordinates").get(1).asDouble();
            longitude = features.get(0).path("geometry").path("coordinates").get(0).asDouble();
            log.info("success! coordinates are : " + "LATITUDE : " + latitude + " LONGITUDE : " + longitude);
            return new Coordinates(latitude, longitude);

        } catch (Exception e) {
            throw new InvalidRequestParam("wrong params added");
        }
    }
}
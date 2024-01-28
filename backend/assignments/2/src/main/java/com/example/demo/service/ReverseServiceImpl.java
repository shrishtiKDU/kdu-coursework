package com.example.demo.service;

import com.example.demo.constant.Url;
import com.example.demo.dto.CoordinatesDto;
import com.example.demo.entity.Address;
import com.example.demo.exceptions.custom.InvalidRequestParam;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of the {@link ReverseService} interface that retrieves an address based on geographical coordinates
 * using the Geoapify API.
 */
@Slf4j
@Service
public class ReverseServiceImpl implements ReverseService {

    /**
     * Retrieves an address based on the provided geographical coordinates.
     *
     * @param coordinatesDto The Data Transfer Object (DTO) representing the geographical coordinates.
     * @return The {@link Address} corresponding to the provided coordinates.
     * @throws InvalidRequestParam If there are issues with the request parameters.
     * @throws RuntimeException    If an unexpected error occurs during the request.
     */

    @Autowired
    private Environment environment;

    @Override
    public Address getAddressByCoordinates(CoordinatesDto coordinatesDto) {
        double lat = coordinatesDto.getLatitude();
        double lon = coordinatesDto.getLongitude();

        log.info("received coordinates from users are : " + "latitude : " + lat + "longitude" + lon);
        String apiKey =  environment.getProperty("api-key");


        String apiUrl = String.format(Url.REVERSE_GEOCODE_API, lat, lon, apiKey);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();
        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse JSON response using Jackson

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode result = objectMapper.readTree(response.body());

            // Check if features array is not empty

            if (validateResult(result)) {
                String formattedAddress = result.get(Url.FEATURES).get(0).get("properties").get("formatted").asText();
                Address address = new Address(formattedAddress);
                log.info("received address is : " + address);
                return address;
            } else {
                log.error("No address found");
                throw new InvalidRequestParam("wrong params");
            }
        } catch (RuntimeException | IOException | InterruptedException exception) {
            log.error("Failed to fetch data ");
            throw new RuntimeException("runtime error");
        }
    }


    public static boolean validateResult(JsonNode result) {
        return result.has(Url.FEATURES) && result.get(Url.FEATURES).isArray() && !result.get(Url.FEATURES).isEmpty();
    }
}

package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoordinatesDto {

    /**
     * The latitude value of the geographical coordinates.
     */
    private double latitude;

    /**
     * The longitude value of the geographical coordinates.
     */
    private double longitude;
}

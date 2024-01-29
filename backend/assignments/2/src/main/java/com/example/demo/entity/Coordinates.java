package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Coordinates {
    /**
     * The latitude value of the geographical coordinates.
     */
    private double latitude;

    /**
     * The longitude value of the geographical coordinates.
     */
    private double longitude;

    /**
     * Default constructor for creating an instance of Coordinates with default values.
     * Typically used when creating an uninitialized instance or for deserialization.
     */

    public Coordinates() {
        // empty constructor
    }
}

package com.example.assignment.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Coordinates {
    private double latitude;
    private double longitude;

    public Coordinates() {

    }
}

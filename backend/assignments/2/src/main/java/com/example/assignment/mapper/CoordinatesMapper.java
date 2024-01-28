package com.example.assignment.mapper;
import com.example.assignment.dto.CoordinatesDto;
import com.example.assignment.entity.Coordinates;

public class CoordinatesMapper {
    public static CoordinatesDto mapToCoordinatesDto(Coordinates coordinates){
        return new CoordinatesDto(
                coordinates.getLatitude(),
                coordinates.getLongitude()
        );
    }

    public static Coordinates mapToAddress(CoordinatesDto coordinatesDto){
        return new Coordinates(
                coordinatesDto.getLatitude(),
                coordinatesDto.getLongitude()
        );
    }
}

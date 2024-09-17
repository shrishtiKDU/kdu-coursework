package com.example.demo.mapper;

import com.example.demo.dto.CoordinatesDto;
import com.example.demo.entity.Coordinates;

public class CoordinatesMapper {


    /**
     * Maps a {@link Coordinates} entity to a {@link CoordinatesDto}.
     *
     * @param coordinates The {@link Coordinates} entity to be mapped.
     * @return A {@link CoordinatesDto} representing the mapped coordinates information.
     */
    public static CoordinatesDto mapToCoordinatesDto(Coordinates coordinates) {
        return new CoordinatesDto(
                coordinates.getLatitude(),
                coordinates.getLongitude()
        );
    }

    /**
     * Maps a {@link CoordinatesDto} to a {@link Coordinates} entity.
     *
     * @param coordinatesDto The {@link CoordinatesDto} to be mapped.
     * @return A {@link Coordinates} entity representing the mapped coordinates information.
     */

    public static Coordinates mapToAddress(CoordinatesDto coordinatesDto) {
        return new Coordinates(
                coordinatesDto.getLatitude(),
                coordinatesDto.getLongitude()
        );
    }
}

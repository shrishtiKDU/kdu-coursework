package com.example.assignment.services;

import com.example.assignment.dto.AddressDto;
import com.example.assignment.entity.Coordinates;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface GeocodingService {
     Coordinates getCoordinatesByAddress(AddressDto addressDto);
}

package com.example.demo.service;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Coordinates;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public interface GeocodingService {

    @Cacheable(key = "#addressDto.getAddress()", value = "geocoding", condition = "!#addressDto.getAddress().equals('goa')")
    Coordinates getCoordinatesByAddress(AddressDto addressDto);
}

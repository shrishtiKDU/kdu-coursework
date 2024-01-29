package com.example.demo.service;

import com.example.demo.dto.CoordinatesDto;
import com.example.demo.entity.Address;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public interface ReverseService {
    @Cacheable(value = "reverse-geocoding", key = "{#coordinatesDto.getLatitude(),#coordinatesDto.getLongitude()}")
    Address getAddressByCoordinates(CoordinatesDto coordinatesDto);

}

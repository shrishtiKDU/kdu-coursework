package com.example.assignment.services;

import com.example.assignment.dto.CoordinatesDto;
import com.example.assignment.entity.Address;
import org.springframework.stereotype.Service;


@Service
public interface ReverseService {

    Address getAddressByCoordinates(CoordinatesDto coordinatesDto);

}

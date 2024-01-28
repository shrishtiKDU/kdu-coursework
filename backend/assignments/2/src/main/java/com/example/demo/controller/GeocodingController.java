package com.example.demo.controller;
import com.example.demo.dto.AddressDto;
import com.example.demo.dto.CoordinatesDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Coordinates;
import com.example.demo.service.GeocodingService;
import com.example.demo.service.ReverseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GeocodingController {

    private GeocodingService geocodingService;
    private ReverseService reverseService;
    @GetMapping("/geocoding")
    public ResponseEntity<Coordinates> getCoordinates(@RequestParam(required = true, name = "address") AddressDto addressDto){
        Coordinates coordinates = geocodingService.getCoordinatesByAddress(addressDto);
        return  new ResponseEntity<>(coordinates, HttpStatus.OK);
    }
    @GetMapping("/reverse-geocoding")
    public ResponseEntity<Address> getAddress(@RequestParam(required = true, name="latitude") double latitude, @RequestParam(required = true, name="longitude") double longitude){
        CoordinatesDto coordinatesDto= new CoordinatesDto(latitude,longitude);
        Address address = reverseService.getAddressByCoordinates(coordinatesDto);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}

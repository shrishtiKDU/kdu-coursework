package com.example.assignment.mapper;

import com.example.assignment.dto.AddressDto;
import com.example.assignment.entity.Address;

public class AddressMapper {
    public static AddressDto mapToAddressDto(Address address){
        return new AddressDto(
                address.getAddress()
        );
    }

    public static Address mapToAddress(AddressDto addressDto){
        return new Address(
                addressDto.getAddress()
        );
    }
}

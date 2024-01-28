package com.example.demo.mapper;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;

public class AddressMapper {

    /**
     * Maps an address entity to an addressDTO
     *
     * @param address The address entity to be mapped.
     * @return An addressDto representing the mapped address information.
     */
    public static AddressDto mapToAddressDto(Address address) {
        return new AddressDto(
                address.getAddress()
        );
    }


    /**
     * Maps an AddressDto to an Address entity.
     *
     * @param addressDto The  AddressDto to be mapped.
     * @return An  Address entity representing the mapped address information.
     */

    public static Address mapToAddress(AddressDto addressDto) {
        return new Address(
                addressDto.getAddress()
        );
    }
}

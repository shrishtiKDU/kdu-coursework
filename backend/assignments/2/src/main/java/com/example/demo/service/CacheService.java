package com.example.demo.service;

import com.example.demo.entity.Address;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Service class for managing caching and handling restricted locations.
 */
@Service
public class CacheService {
    /**
     * List of restricted cache locations.
     */
    List<String> restrictLocations = new ArrayList<>(Arrays.asList("goa"));


    /**
     * Adds a location to the list of restricted cache locations.
     *
     * @param location The location to be added.
     */

    public void addRestrictedCacheLocation(String location) {
        restrictLocations.add(location.toLowerCase());
    }


    /**
     * Removes a location from the list of restricted cache locations.
     *
     * @param location The location to be removed.
     */


    public void removeRestrictedCacheLocation(String location) {
        restrictLocations.removeIf(field -> location.toLowerCase().equals(field));
    }

    /**
     * Checks if the provided address is in any of the restricted cache locations.
     *
     * @param address The address to be checked.
     * @return True if the address is in a restricted location, false otherwise.
     */

    public boolean checkRestrictedCaching(Address address) {
        for (String location : restrictLocations) {
            if (restrictedLocationValidator(address, location)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates if the given address contains the specified restricted location.
     *
     * @param address  The address to be validated.
     * @param location The restricted location to check.
     * @return True if the address contains the restricted location, false otherwise.
     */

    public boolean restrictedLocationValidator(Address address, String location) {
        if (checkNull(address.getAddress()) && address.getAddress().toLowerCase().contains(location)) return true;
        return checkNull(address.getAddress()) && address.getAddress().toLowerCase().contains(location);
    }

    /**
     * Checks if the provided object is not null.
     *
     * @param obj The object to be checked.
     * @return True if the object is not null, false otherwise.
     */
    public boolean checkNull(Object obj) {
        return !(Objects.isNull(obj));
    }

    /**
     * Checks if both latitude and longitude are not null.
     *
     * @param latitude  The latitude to be checked.
     * @param longitude The longitude to be checked.
     * @return True if both latitude and longitude are not null, false otherwise.
     */

    public boolean checkLocation(String latitude, String longitude) {
        return !(checkNull(latitude) || checkNull(longitude));
    }

    /**
     * Checks if the provided address is not null.
     *
     * @param address The address to be checked.
     * @return True if the address is not null, false otherwise.
     */

    public boolean checkAddress(String address) {
        return !checkNull(address);
    }
}


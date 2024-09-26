package com.example.spring.service;


import com.example.spring.dao.AddressDAO;
import com.example.spring.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressDAO addressDAO;


    // to add address
    public Address saveAddress(Address address){
        return addressDAO.save(address);
    }

}

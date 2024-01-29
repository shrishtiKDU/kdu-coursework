package com.example.spring.service;

import com.example.spring.dao.PersonDAO;
import com.example.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAdditionService implements CommandLineRunner {

    /** The data access object for interacting with the database. */
    @Autowired
    PersonDAO personDAO;

    /** The password encoder for securely encoding passwords. */
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Adds initial user data to the database on application startup.
     *
     * @param args Command line arguments (not used in this implementation).
     * @throws Exception If an exception occurs during the execution of the command line runner.
     */

    @Override
    public void run(String... args) throws Exception{
        personDAO.addPerson(new Person("Shrishti", "shrishti", passwordEncoder.encode("Secure@123"), "ROLE_ADMIN"));
        personDAO.addPerson(new Person("Thanika", "thanika", passwordEncoder.encode("Password@123"), "ROLE_BASIC"));
    }



}

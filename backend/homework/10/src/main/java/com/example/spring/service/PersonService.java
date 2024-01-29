package com.example.spring.service;


import com.example.spring.dao.PersonDAO;
import com.example.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonDAO personDAO;

    public void addPerson(Person person){
        personDAO.addPerson(person);
    }

    public Person getPersonById(int id){
        return personDAO.getPersonById(id);
    }

    public String getRoleById(int id){
        return personDAO.getRoleByPersonId(id);
    }

    public Person getPersonUserName(String name){
        for(Person p: personDAO.getAllPersons()){
            if(p.getUserName().equals(name)){
                return p;
            }
        }
        return null;
    }
}

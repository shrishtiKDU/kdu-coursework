package com.example.spring.dao;

import com.example.spring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;



@Repository
public interface PersonDAO extends JpaRepository<Person, Integer> {



//    public PersonDAO() {
//        this.personList = new ArrayList<>();
//    }
//
//    public void addPerson(Person person){
//        personList.add(person);
//    }
//
//    public Person getPersonById(int index){
//        return personList.get(index);
//    }
//
//    public String getRoleByPersonId(int index){
//        return personList.get(index).getRole();
//    }

//    public List<Person> getAllPersons(){
//        return personList;
//    }
}




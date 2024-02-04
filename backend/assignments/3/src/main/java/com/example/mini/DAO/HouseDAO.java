package com.example.mini.DAO;


import com.example.mini.entity.House;
import com.example.mini.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseDAO extends JpaRepository<House,String> {

    @Query(value = "SELECT h FROM House h WHERE h.houseId=?1")
    public House getHouseById(String username);
}


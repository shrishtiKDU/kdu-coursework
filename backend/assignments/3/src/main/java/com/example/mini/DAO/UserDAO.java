package com.example.mini.DAO;

import com.example.mini.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    @Query
    Optional<User>findByUserName(String userName);

    @Query(value = "SELECT u FROM User u WHERE u.userId=?1")
    public User getById(int id);


    @Query(value = "SELECT u FROM User u WHERE u.userName=?1")
    public User getByUserName(String username);

}

package com.example.jpa.repository;

import com.example.jpa.entity.Shift;
import com.example.jpa.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    Page<User> findAll(Pageable pageable);

    //  @Query(value = "SELECT * FROM user", countQuery = "SELECT count(*) FROM user", nativeQuery = true)
    @Modifying
    @Transactional
    @Query(value = "UPDATE users u SET u.username = :userName WHERE u.user_id = :userId", nativeQuery = true)
    int updateUserName(String userName, UUID userId);

}
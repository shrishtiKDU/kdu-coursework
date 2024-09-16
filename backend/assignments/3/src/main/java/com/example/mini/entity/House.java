package com.example.mini.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "house_id")
    private Long houseId;
    @Column(name = "house_name")
    private String houseName;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "house")
    @JsonManagedReference
    private List<Room> rooms;
    @ManyToMany(mappedBy = "houses",cascade = CascadeType.ALL)
    private List<User> users;
}

package com.example.mini.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "roomname")
    private String roomName;

    @ManyToOne
    @JoinColumn(name = "house_id")
    @JsonBackReference
    private House house;

    @OneToMany(mappedBy = "room")
    @JsonManagedReference
    private List<Device> devices;
}

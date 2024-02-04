package com.example.mini.DAO;

import com.example.mini.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomDAO extends JpaRepository<Room, Integer> {


//    @Query()
//    public Room saveRoomToHouse(Room room, String houseId);
}

package com.myWebsite.reposity;

import com.myWebsite.entity.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomReposity extends CrudRepository<Room,Long> {
    List<Room> findRoomsByApartment_Id(Long id);
}

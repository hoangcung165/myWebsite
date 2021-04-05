package com.myWebsite.service.Interface;

import com.myWebsite.entity.Room;

import java.util.List;

public interface RoomService {
    Room save(Room room);
    List<Room> findAllbyApartId(Long id);
    Room findById(Long id);
}

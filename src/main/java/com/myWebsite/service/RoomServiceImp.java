package com.myWebsite.service;

import com.myWebsite.entity.Room;
import com.myWebsite.reposity.RoomReposity;
import com.myWebsite.service.Interface.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomServiceImp implements RoomService {
    @Autowired
    private RoomReposity roomReposity;
    @Override
    public Room save(Room room) {
        return roomReposity.save(room);
    }

    @Override
    public List<Room> findAllbyApartId(Long id) {
        return roomReposity.findRoomsByApartment_Id(id);
    }

}

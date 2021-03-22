package com.myWebsite.service;

import com.myWebsite.entity.Room;
import com.myWebsite.reposity.RoomReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoomServiceImp implements  RoomService{
    @Autowired
    private RoomReposity roomReposity;
    @Override
    public Room save(Room room) {
        return roomReposity.save(room);
    }

}

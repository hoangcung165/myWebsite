package com.myWebsite.service;

import com.myWebsite.entity.RoomName;
import com.myWebsite.entity.TypeRoom;
import com.myWebsite.reposity.RoomNameReposity;
import com.myWebsite.reposity.TypeRoomReposity;
import com.myWebsite.service.Interface.RoomNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class RoomNameServiceImpl implements RoomNameService {
    @Autowired
    private RoomNameReposity roomNameReposity;
    @Override
    public List<RoomName> findByTypeRoom(TypeRoom typeRoom) {
        return roomNameReposity.findAllByTypeRoom(typeRoom);
    }

    @Override
    public RoomName findById(Long id) {
        return roomNameReposity.findById(id).get();
    }

    @Override
    public List<RoomName> findAll() {
        return roomNameReposity.findAll();
    }

    @Override
    public boolean save(RoomName roomName) {
        try {
            roomNameReposity.save(roomName);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }
}

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
}

package com.myWebsite.service.Interface;

import com.myWebsite.entity.RoomName;
import com.myWebsite.entity.TypeRoom;

import java.util.List;

public interface RoomNameService {
    List<RoomName> findByTypeRoom(TypeRoom typeRoom);
    RoomName findById(Long id);
    List<RoomName> findAll();
    boolean save(RoomName roomName);
}

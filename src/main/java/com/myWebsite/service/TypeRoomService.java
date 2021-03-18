package com.myWebsite.service;

import com.myWebsite.entity.TypeRoom;

public interface TypeRoomService {
    TypeRoom save(TypeRoom typeRoom);
    TypeRoom findByID(Long id);
}

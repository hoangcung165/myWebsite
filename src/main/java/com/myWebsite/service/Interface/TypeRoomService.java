package com.myWebsite.service.Interface;

import com.myWebsite.entity.TypeRoom;

import java.util.List;

public interface TypeRoomService {
    TypeRoom save(TypeRoom typeRoom);
    TypeRoom findByID(Long id);
    List<TypeRoom> findAll();
    boolean deleteById(Long id);
    boolean update(Long id,String newName);
}

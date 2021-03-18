package com.myWebsite.service;

import com.myWebsite.entity.TypeRoom;
import com.myWebsite.reposity.TypeRoomReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TypeRoomServiceImp implements TypeRoomService{

    @Autowired
    private TypeRoomReposity typeRoomReposity;
    @Override
    public TypeRoom save(TypeRoom typeRoom) {
        return (TypeRoom) typeRoomReposity.save(typeRoom);
    }

    @Override
    public TypeRoom findByID(Long id) {
        return typeRoomReposity.findById(id).get();
    }
}

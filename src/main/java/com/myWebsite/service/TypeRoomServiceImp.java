package com.myWebsite.service;

import com.myWebsite.entity.TypeRoom;
import com.myWebsite.reposity.TypeRoomReposity;
import com.myWebsite.service.Interface.TypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypeRoomServiceImp implements TypeRoomService {

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

    @Override
    public List<TypeRoom> findAll() {
        return (List<TypeRoom>) typeRoomReposity.findAll();
    }
}

package com.myWebsite.service;

import com.myWebsite.dto.RoomDTO;
import com.myWebsite.entity.Room;
import com.myWebsite.reposity.RoomReposity;
import com.myWebsite.service.Interface.ApartmentService;
import com.myWebsite.service.Interface.RoomNameService;
import com.myWebsite.service.Interface.RoomService;
import com.myWebsite.service.Interface.TypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomServiceImp implements RoomService {
    @Autowired
    private RoomReposity roomReposity;
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private TypeRoomService typeRoomService;
    @Autowired
    private RoomNameService roomNameService;
    @Override
    public Room save(Room room) {
        return roomReposity.save(room);
    }

    @Override
    public List<Room> findAllbyApartId(Long id) {
        return roomReposity.findRoomsByApartment_Id(id);
    }

    @Override
    public Room findById(Long id) {
        return roomReposity.findById(id).get();
    }

    @Override
    public boolean addNewRoomForApartment(Long apartmentId, RoomDTO roomDTO) {
        try {
            Room room=new Room();
            room.setApartment(apartmentService.findById(apartmentId));
            room.setTypeRoom(typeRoomService.findByID(roomDTO.getTypeRoom()));
            room.setRoomName(roomNameService.findById(roomDTO.getRoomName()));
            room.setQuantity_rooms(roomDTO.getQty_room());
            room.setSize(roomDTO.getSize());
            room.setPrice(roomDTO.getPrice());
            room.setAmount_bed(roomDTO.getQtyBeds());
            room.setQuantityCustomer(roomDTO.getQty_customer());
            roomReposity.save(room);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }


}

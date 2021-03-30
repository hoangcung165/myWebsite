package com.myWebsite.service;

import com.myWebsite.dto.HotelRegister;
import com.myWebsite.entity.*;
import com.myWebsite.service.Interface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class SaveNewHotelServiceImpl implements SaveNewHotelService {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private PersonService personService;
    @Autowired
    private TypeApartmentService typeApartmentService;
    @Autowired
    private TinhService tinhService;

    @Autowired
    private HuyenService huyenService;

    @Autowired
    private XaService xaService;

    @Autowired
    private TypeRoomService typeRoomService;

    @Autowired
    private RoomNameService roomNameService;

    @Autowired
    private RoomService roomService;
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private AddressService addressService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ServiceHotelService serviceHotelService;
    @Autowired
    private HaveServiceS haveServiceS;
    @Override
    public boolean saveNewHotel(HotelRegister hotelRegister) {
        Apartment apartment=new Apartment();
        apartment.setAddressApartment(getAddress(hotelRegister.getIdCity(), hotelRegister.getIdDistrict(), hotelRegister.getIdWard(), hotelRegister.getHouseNumber()));
        apartment.setName(hotelRegister.getName());
        apartment.setOwner(getManager(hotelRegister.getId_user()));
        apartment.setTypeApartment(getTypeApartment(hotelRegister.getTypeApartment()));

        if(apartmentService.save(apartment)){
            try {
                setRoom(hotelRegister.getRoomName(), hotelRegister.getTypeRoom(), hotelRegister.getSmokking(), hotelRegister.getQtyBeds(),hotelRegister.getPrice(),hotelRegister.getQty_customer(),hotelRegister.getQty_room(),apartment);
                setImageList(hotelRegister.getListImages(),apartment);
                setService(hotelRegister.getListService(),apartment);
                return true;
            }
            catch (Exception e){
                return false;
            }

        }
        return false;

    }

    private Manager getManager(String id){
        Long id_user=Long.parseLong(id);
        Person person= personService.findById(id_user);
        return managerService.findByPerson(person);
    }
    private TypeApartment getTypeApartment(String id){
        Long type_id=Long.parseLong(id);
        return typeApartmentService.findById(type_id);
    }
    private Address getAddress(String idCity,String idDistrict,String idWard,String houseNumber){
        devvn_tinhthanhpho tinhthanhpho=tinhService.findById(idCity);
        devvn_quanhuyen quanhuyen= huyenService.findById(idDistrict);
        devvn_xaphuongthitran xaphuongthitran=xaService.findById(idWard);
        Address address=new Address();
        address.setHouseNum(houseNumber);
        address.setTinhthanhphoAddress(tinhthanhpho);
        address.setQuanhuyenAddress(quanhuyen);
        address.setXaphuongthitranAddress(xaphuongthitran);
        addressService.save(address);
        return address;
    }
    private RoomName getRoomName(String RoomName){
        Long roomNameId=Long.parseLong(RoomName);
        return roomNameService.findById(roomNameId);
    }
    private TypeRoom getTypeRoom(String typeRoom){
        Long typeRoomId=Long.parseLong(typeRoom);
        return typeRoomService.findByID(typeRoomId);
    }
//    saveRoom
    private void setRoom(String roomName,String typeRoom,String smoking,int beds,int price,int qty_customer,int quantity_rooms,Apartment apartment){

        Room room=new Room();
        room.setSmoking(smoking);
        room.setAmount_bed(beds);
        room.setQuantityCustomer(qty_customer);
        room.setPrice(price);
        room.setTypeRoom(getTypeRoom(typeRoom));
        room.setRoomName(getRoomName(roomName));
        room.setApartment(apartment);
        roomService.save(room);

    }
    private void setImageList(List<CommonsMultipartFile> files,Apartment apartment){
        for(CommonsMultipartFile file:files){
            imageService.uploadForApartment(file,apartment);
        }
    }
    private void setService(List<String> services,Apartment apartment){

        for(String s:services){
            Long id=Long.parseLong(s);
            Servicehotel servicehotel= serviceHotelService.findById(id);
            HaveService haveService=new HaveService();
            haveService.setApartmentHave(apartment);
            haveService.setServicehotelHave(servicehotel);
            haveServiceS.save(haveService);
        }
    }

}

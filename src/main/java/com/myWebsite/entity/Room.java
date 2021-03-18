package com.myWebsite.entity;

import javax.persistence.*;

@Entity
@Table(name = "Room")
public class Room extends BaseEntity{


    @Column(name = "smoking")
    private String smoking;
    @Column(name = "amout")
    private int amout;
    @Column(name = "maxCustomer")
    private int maxCustomer;
    @Column(name = "size")
    private int size;
    @Column(name = "price")
    private int price;
//    private String codeSale;

    @OneToOne
    @JoinColumn(name = "typeRoom_id",referencedColumnName = "id")
    private TypeRoom typeRoom;

    @OneToOne
    @JoinColumn(name = "roomName_id",referencedColumnName = "id")
    private RoomName roomName;
    public Room() {
    }
    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    public RoomName getRoomName() {
        return roomName;
    }

    public void setRoomName(RoomName roomName) {
        this.roomName = roomName;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }

    public int getMaxCustomer() {
        return maxCustomer;
    }

    public void setMaxCustomer(int maxCustomer) {
        this.maxCustomer = maxCustomer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

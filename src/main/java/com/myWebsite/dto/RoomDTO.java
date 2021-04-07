package com.myWebsite.dto;

public class RoomDTO {
    private Long typeRoom;
    private Long RoomName;
    private Long kindOfBed;
    private int qtyBeds;
    private int qty_room;
    private int size;
    private int price;
    private int qty_customer;

    public RoomDTO() {
    }

    public RoomDTO(Long typeRoom, Long roomName, Long kindOfBed, int qtyBeds, int qty_room, int size, int price, int qty_customer) {
        this.typeRoom = typeRoom;
        RoomName = roomName;
        this.kindOfBed = kindOfBed;
        this.qtyBeds = qtyBeds;
        this.qty_room = qty_room;
        this.size = size;
        this.price = price;
        this.qty_customer = qty_customer;
    }

    public Long getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(Long typeRoom) {
        this.typeRoom = typeRoom;
    }

    public Long getRoomName() {
        return RoomName;
    }

    public void setRoomName(Long roomName) {
        RoomName = roomName;
    }

    public Long getKindOfBed() {
        return kindOfBed;
    }

    public void setKindOfBed(Long kindOfBed) {
        this.kindOfBed = kindOfBed;
    }

    public int getQtyBeds() {
        return qtyBeds;
    }

    public void setQtyBeds(int qtyBeds) {
        this.qtyBeds = qtyBeds;
    }

    public int getQty_room() {
        return qty_room;
    }

    public void setQty_room(int qty_room) {
        this.qty_room = qty_room;
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

    public int getQty_customer() {
        return qty_customer;
    }

    public void setQty_customer(int qty_customer) {
        this.qty_customer = qty_customer;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "typeRoom=" + typeRoom +
                ", RoomName=" + RoomName +
                ", kindOfBed=" + kindOfBed +
                ", qtyBeds=" + qtyBeds +
                ", qty_room=" + qty_room +
                ", size=" + size +
                ", price=" + price +
                ", qty_customer=" + qty_customer +
                '}';
    }
}

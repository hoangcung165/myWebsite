package com.myWebsite.dto;

public class bookingFormDTO {
    private Long apartment_id;
    private Long room_id;
    private int payment;
    private String beginDate;
    private String endDate;
    private int qty_Cus;
    private int qty_Room;

    public bookingFormDTO() {
    }

    public bookingFormDTO(Long apartment_id, Long room_id, int payment, String beginDate, String endDate, int qty_Cus, int qty_Room) {
        this.apartment_id = apartment_id;
        this.room_id = room_id;
        this.payment = payment;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.qty_Cus = qty_Cus;
        this.qty_Room = qty_Room;
    }

    public Long getApartment_id() {
        return apartment_id;
    }

    public void setApartment_id(Long apartment_id) {
        this.apartment_id = apartment_id;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getQty_Cus() {
        return qty_Cus;
    }

    public void setQty_Cus(int qty_Cus) {
        this.qty_Cus = qty_Cus;
    }

    public int getQty_Room() {
        return qty_Room;
    }

    public void setQty_Room(int qty_Room) {
        this.qty_Room = qty_Room;
    }

    @Override
    public String toString() {
        return "bookingFormDTO{" +
                "apartment_id=" + apartment_id +
                ", room_id=" + room_id +
                ", payment=" + payment +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", qty_Cus=" + qty_Cus +
                ", qty_Room=" + qty_Room +
                '}';
    }
}

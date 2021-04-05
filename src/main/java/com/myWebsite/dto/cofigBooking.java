package com.myWebsite.dto;

public class cofigBooking {
    private int qtyRoomMax;
    private int dates;
    private int price;

    public cofigBooking() {
    }

    public cofigBooking(int qtyRoomMax, int dates) {
        this.qtyRoomMax = qtyRoomMax;
        this.dates = dates;
    }

    public int getQtyRoomMax() {
        return qtyRoomMax;
    }

    public void setQtyRoomMax(int qtyRoomMax) {
        this.qtyRoomMax = qtyRoomMax;
    }

    public int getDates() {
        return dates;
    }

    public void setDates(int dates) {
        this.dates = dates;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "cofigBooking{" +
                "qtyRoomMax=" + qtyRoomMax +
                ", dates=" + dates +
                ", price=" + price +
                '}';
    }
}

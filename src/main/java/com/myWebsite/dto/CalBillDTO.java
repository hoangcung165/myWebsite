package com.myWebsite.dto;

public class CalBillDTO {
    private float out;

    public CalBillDTO(float out) {
        this.out = out;
    }

    public CalBillDTO() {
    }

    public float getOut() {
        return out;
    }

    public void setOut(float out) {
        this.out = out;
    }
}

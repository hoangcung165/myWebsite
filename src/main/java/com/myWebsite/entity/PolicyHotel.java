package com.myWebsite.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "policyHotel")
public class PolicyHotel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean child;
    private boolean pet;
    private boolean cancel;
    private String timeReceiveRoom;
    private String timeLeaveRoom;

    public PolicyHotel() {
    }

    public boolean isChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }

    public boolean isPet() {
        return pet;
    }

    public void setPet(boolean pet) {
        this.pet = pet;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeReceiveRoom() {
        return timeReceiveRoom;
    }

    public void setTimeReceiveRoom(String timeReceiveRoom) {
        this.timeReceiveRoom = timeReceiveRoom;
    }

    public String getTimeLeaveRoom() {
        return timeLeaveRoom;
    }

    public void setTimeLeaveRoom(String timeLeaveRoom) {
        this.timeLeaveRoom = timeLeaveRoom;
    }
}

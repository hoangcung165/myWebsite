package com.myWebsite.entity;

public class PolicyHotel extends BaseEntity{
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

package com.myWebsite.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "typeRoom")
public class TypeRoom extends BaseEntity{
    @Column(name = "type")
    private String Type;

    @OneToMany(mappedBy = "typeRoom",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private List<RoomName> roomNames=new ArrayList<>();
    public TypeRoom() {
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public List<RoomName> getRoomNames() {
        return roomNames;
    }

    public void setRoomNames(List<RoomName> roomNames) {
        this.roomNames = roomNames;
    }
}

package com.myWebsite.entity;

import javax.persistence.*;

@Entity
@Table(name = "bed")
public class Bed extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;


//    @ManyToOne
//    @JoinColumn(name = "room_id")
//    private Room roomBed;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room inRoom;

    public Bed() {
    }

    public Bed(Long id, String typeName, Room roomBed) {
        this.id = id;
        this.typeName = typeName;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


}

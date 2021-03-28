package com.myWebsite.entity;

import javax.persistence.*;

@Entity
@Table(name = "bed")
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;
    private int amount;

    @ManyToOne
    @JoinColumn(name = "room_id",nullable = false)
    private Room roomBed;
    public Bed() {
    }

    public Bed(Long id, String typeName, int amount) {
        this.id = id;
        this.typeName = typeName;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

package com.example.gametestproject.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Balance_Id")
    private Integer id;

    @Column(name = "Player_Id")
    private String name;
}

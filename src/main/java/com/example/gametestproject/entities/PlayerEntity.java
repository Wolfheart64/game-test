package com.example.gametestproject.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Transaction_Id")
    private Integer transactionId;

    @Column(name = "Player_Id")
    private Integer playerId;

    @Column(name = "Player_Username")
    private String name;

    @Column(name = "Player_Balance")
    private int balanceAmount;
}

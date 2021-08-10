package com.example.gametestproject.entities;

import lombok.Data;


@Data
public class PlayerDto {
    private int TransactionId;

    private int playerId;

    private String name;

    private int balanceAmount;
}

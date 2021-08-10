package com.example.gametestproject.requests;

import lombok.Data;

@Data
public class PlayerRequest {

    private int transcationId;

    private int playerId;

    private int amount;
}

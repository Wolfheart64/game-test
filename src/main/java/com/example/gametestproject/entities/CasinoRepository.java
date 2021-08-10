package com.example.gametestproject.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CasinoRepository extends JpaRepository<PlayerEntity, Integer> {
    PlayerEntity findByTransactionId(int id);

    PlayerEntity findAllByPlayerId(int id);

    PlayerEntity findByPlayerId(int id);
}


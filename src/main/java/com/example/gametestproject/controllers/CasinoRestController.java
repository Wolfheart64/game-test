package com.example.gametestproject.controllers;

import com.example.gametestproject.entities.PlayerDto;
import com.example.gametestproject.entities.PlayerEntity;
import com.example.gametestproject.services.CasinoRestServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CasinoRestController {

    private final CasinoRestServices casinoRestServices;

    public CasinoRestController(CasinoRestServices casinoRestServices) {
        this.casinoRestServices = casinoRestServices;
    }

    @GetMapping("/ping")
    @ResponseStatus(code = HttpStatus.OK)
    public String ping() {
        return "This service is up";
    }

    @GetMapping("player/balance/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<PlayerDto> getCasino(@PathVariable int id)
    {
        return  casinoRestServices.getPlayer(id);
    }

    @PostMapping("/player")
    public PlayerEntity createUser(@RequestBody PlayerEntity casinoEntity){

        return casinoRestServices.addCasinoUser(casinoEntity);
    }

    @PostMapping("/player/wagering")
    public PlayerDto wagering(@RequestBody PlayerDto playerDto) throws Exception {

        return casinoRestServices.wagerPlayer(playerDto);
    }

    @PostMapping("/player/winning")
    public PlayerDto winning(@RequestBody PlayerDto playerDto){

        return casinoRestServices.winPlayer(playerDto);
    }


}

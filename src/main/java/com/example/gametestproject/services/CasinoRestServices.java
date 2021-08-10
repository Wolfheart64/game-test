package com.example.gametestproject.services;

import com.example.gametestproject.entities.CasinoRepository;
import com.example.gametestproject.entities.PlayerDto;
import com.example.gametestproject.entities.PlayerEntity;
import ma.glasnost.orika.MapperFacade;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CasinoRestServices {

    private final CasinoRepository casinoRepository;

    private final MapperFacade mapperFacade;

    public CasinoRestServices(CasinoRepository casinoRepository, MapperFacade mapperFacade) {
        this.casinoRepository = casinoRepository;
        this.mapperFacade = mapperFacade;
    }

    public List<PlayerDto> getPlayer(int id)
    {
        List<PlayerDto> playerDtoList = null;
        PlayerDto playerDto = mapperFacade.map(casinoRepository.findAllByPlayerId(i d), PlayerDto.class);
        playerDtoList.add(playerDto);
        return playerDtoList;
    }

    public PlayerEntity addCasinoUser(PlayerEntity casinoEntity) {

        return casinoRepository.save(casinoEntity);
    }

    public PlayerDto wagerPlayer(PlayerDto playerDto) throws Exception {

        try {
            PlayerEntity existingPlayerEntity = casinoRepository.findByPlayerId(playerDto.getPlayerId());

            int updatedWageBalance = existingPlayerEntity.getBalanceAmount() - playerDto.getBalanceAmount();
            existingPlayerEntity.setBalanceAmount(updatedWageBalance);
            PlayerEntity savedPlayerEntity = casinoRepository.save(existingPlayerEntity);

            if (savedPlayerEntity.getBalanceAmount() <= 0) {
                throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
            }
            return mapperFacade.map(savedPlayerEntity, PlayerDto.class);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public PlayerDto winPlayer(PlayerDto playerDto){
try {


    PlayerEntity existingPlayerEntity = casinoRepository.findByPlayerId(playerDto.getPlayerId());
    int updatedWageBalance = existingPlayerEntity.getBalanceAmount() + playerDto.getBalanceAmount();
    existingPlayerEntity.setBalanceAmount(updatedWageBalance);
    PlayerEntity savedPlayerEntity = casinoRepository.save(existingPlayerEntity);
    return mapperFacade.map(savedPlayerEntity, PlayerDto.class);
} catch (Exception e) {
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
}



    }
}

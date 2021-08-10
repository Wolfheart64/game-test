package com.example.gametestproject.configurations;

import com.example.gametestproject.entities.PlayerDto;
import com.example.gametestproject.entities.PlayerEntity;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrikaMapperConfiguration {
    @Bean
    public MapperFactory mapperFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(PlayerEntity.class, PlayerDto.class)
                .byDefault()
                .register();


        return mapperFactory;
    }

    @Bean
    public MapperFacade mapperFacade() {
        return mapperFactory().getMapperFacade();
    }
}

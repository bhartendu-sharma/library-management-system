package com.apps.librarymanagementapp.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apps.librarymanagementapp.mapper.BookMapper;

@Configuration
public class MapStructConfig {

    @Bean
    public BookMapper bookMapper() {
        return Mappers.getMapper(BookMapper.class);
    }
}

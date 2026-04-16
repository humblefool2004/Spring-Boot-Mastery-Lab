package com.Week02Codes.SpringBootWebApplication.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapperConfigs {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}

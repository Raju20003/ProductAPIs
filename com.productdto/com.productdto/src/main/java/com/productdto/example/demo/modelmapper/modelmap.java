package com.productdto.example.demo.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class modelmap {

    @Bean
    public ModelMapper modelmapper(){
        return new ModelMapper();
    }
}

package com.socialmedia.test.configration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;


import org.springframework.stereotype.Component;

@Component
public class ProjectConfiguration {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

}

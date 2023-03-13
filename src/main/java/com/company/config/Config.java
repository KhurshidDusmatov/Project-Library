package com.company.config;

import com.company.controller.AuthController;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.company")
public class Config {

//    @Bean
//    public AuthController initDataBase(){
//        AuthController authController = new AuthController();
//        return authController;
//    }
}

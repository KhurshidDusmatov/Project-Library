package com.company;

import com.company.controller.AuthController;
import com.company.db.DataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        DataBase.initTable();

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AuthController authController = (AuthController) context.getBean("authController");
        authController.run();
    }
}

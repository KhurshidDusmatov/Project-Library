package com.company;

import com.company.config.Config;
import com.company.controller.AuthController;
import com.company.db.DataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        DataBase.initTable();

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AuthController authController = (AuthController) context.getBean("authController");
        authController.run();
    }
}

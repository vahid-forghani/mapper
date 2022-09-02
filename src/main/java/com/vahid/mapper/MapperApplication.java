package com.vahid.mapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
public class MapperApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(MapperApplication.class, args);
        var userService = context.getBean(UserService.class);
        userService.doSomething();
    }

}

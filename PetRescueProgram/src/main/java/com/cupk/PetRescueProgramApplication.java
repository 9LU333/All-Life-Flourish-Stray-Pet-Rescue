package com.cupk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cupk.mapper")
public class PetRescueProgramApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetRescueProgramApplication.class, args);
    }

}

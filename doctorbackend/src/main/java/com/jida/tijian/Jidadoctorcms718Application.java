package com.jida.tijian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jida.tijian.mapper")
public class Jidadoctorcms718Application {

    public static void main(String[] args) {
        SpringApplication.run(Jidadoctorcms718Application.class, args);
    }

}

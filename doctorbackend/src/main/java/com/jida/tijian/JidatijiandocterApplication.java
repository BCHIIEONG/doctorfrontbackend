package com.jida.tijian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jida.tijian.mapper")
public class JidatijiandocterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JidatijiandocterApplication.class, args);
    }

}

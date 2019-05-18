package com.example.majormanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
/*@EnableCaching */
public class MajormanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MajormanageApplication.class, args);
    }

}

package com.example.demo;

import com.example.demo.configuration.PasswordEncoderConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Base64;

@EnableScheduling
@EnableSwagger2
@SpringBootApplication
@MapperScan(basePackages = {"com.example.demo.repositories"})
public class NhApiApplication  implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(NhApiApplication.class, args);
    }
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(passwordEncoder.encode("NH_api_1508"));
        System.out.println(passwordEncoder.encode("Wing@999"));
        System.out.println(Base64.getEncoder().encodeToString("Admin:NH_api_1508".getBytes()));





    }

}


package com.example.testing1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//
//import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

//@EnableEncryptableProperties
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Testing1Application {

	public static void main(String[] args) {
		SpringApplication.run(Testing1Application.class, args);
		System.out.println("server is running...");
	}

}

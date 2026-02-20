package org.example.nameservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NameserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NameserviceApplication.class, args);
    }

}

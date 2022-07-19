package com.nttdata.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class CustomerServiceBc072022Application {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceBc072022Application.class, args);
    }

}

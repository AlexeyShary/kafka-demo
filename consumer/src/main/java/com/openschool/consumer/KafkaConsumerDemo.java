package com.openschool.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerDemo {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(KafkaConsumerDemo.class, args);
    }
}

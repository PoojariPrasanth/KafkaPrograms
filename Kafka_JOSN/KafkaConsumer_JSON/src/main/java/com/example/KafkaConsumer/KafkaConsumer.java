package com.example.KafkaConsumer;

import com.example.KafkaProducer.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

//    @KafkaListener(topics="Java1",groupId = "JavaGroup")
//    public void consume(String message){
//        LOGGER.info(String.format("message received %s",message.toString()));
//    }

    @KafkaListener(topics = "Json3",groupId = "JsonGroup3")
    public void consume1(Customer customer){
        LOGGER.info(String.format("Json Message consumed successfully %s",customer.toString()));
    }



}

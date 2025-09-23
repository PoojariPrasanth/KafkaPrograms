package com.example.KafkaConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics="${kafka.topic.name}",groupId = "group-7")
    public void consume(String message){
        LOGGER.info(String.format("consumer1 received message: %s",message.toString()));
    }

    @KafkaListener(topics="${kafka.topic.name}",groupId = "group-7")
    public void consume2(String message){
        LOGGER.info(String.format("consumer2 received message: %s",message.toString()));
    }

    @KafkaListener(topics="${kafka.topic.name}",groupId = "group-7")
    public void consume3(String message){
        LOGGER.info(String.format("consumer3 received message: %s",message.toString()));
    }

    @KafkaListener(topics="${kafka.topic.name}",groupId = "group-7")
    public void consume4(String message){
        LOGGER.info(String.format("consumer4 received message: %s",message.toString()));
    }

    @KafkaListener(topics="${kafka.topic.name}",groupId = "group-7")
    public void consume5(String message){
        LOGGER.info(String.format("consumer4 received message: %s",message.toString()));
    }

}

package com.example.KafkaProducer.service;

import com.example.KafkaProducer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void sendJsonMessage(Customer customer){
        CompletableFuture<SendResult<String,Object>> future = kafkaTemplate.send("Json3",customer);
        future.whenComplete((result,exception)->{
            if(exception == null){
                System.out.println("message sended successfully with offset["+result.getRecordMetadata().offset()+"]");
            }else {
                System.out.println("failed to send message");
            }
        });
    }

}

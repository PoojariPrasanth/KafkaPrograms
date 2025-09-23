package com.example.KafkaProducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    public void sendMessage(String message){
        CompletableFuture<SendResult<String, Object>> future= kafkaTemplate.send("Prasanth_topic8",message);
        future.whenComplete((result,ex)->{
            System.out.println(result.getRecordMetadata().partition());
            if(ex==null){
                System.out.println("message sent successfully ["+message+"]"+"with offset ["+result.getRecordMetadata().offset()+"]");
            }else{
                System.out.println("unable to send message due to "+ex.getMessage());
            }
        });
    }

}

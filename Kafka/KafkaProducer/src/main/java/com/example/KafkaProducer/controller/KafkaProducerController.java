package com.example.KafkaProducer.controller;

import com.example.KafkaProducer.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> send(@PathVariable String message){
        try{
            for(int i=1;i<=10000;i++){
                kafkaProducer.sendMessage(message);
            }
            System.out.println("hii"+message);

            return ResponseEntity.ok(Map.of("message","message sent successfully"));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

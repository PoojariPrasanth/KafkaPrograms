package com.example.KafkaProducer.controller;

import com.example.KafkaProducer.entity.Customer;
import com.example.KafkaProducer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

//    @GetMapping("/publish/{message}")
//    public ResponseEntity<?> sendMessage(@PathVariable String message){
//        try{
//            for(int i=1;i<=10000;i++){
//                System.out.println("message sent "+message);
//                kafkaProducerService.sendMessage(message);
//            }
//            return ResponseEntity.ok(Map.of("message","messages sent successfully"));
//        }
//        catch (Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to send");
//        }
//    }

    @GetMapping("/publish")
    public void sendJsonMessage(@RequestBody Customer customer){
        try{
            kafkaProducerService.sendJsonMessage(customer);
            System.out.println("Json message sent successfully "+customer);
        }catch (Exception e){
            System.out.println("Json message failed to send"+e.getMessage());
        }
    }


}

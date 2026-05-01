package com.example.RegisterationService.Services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class RegisterEmailProducer {

    private final  KafkaTemplate<String, String> kafkatemplate;

    public RegisterEmailProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkatemplate = kafkaTemplate;
    }


    public void  SendUserEvent(String e){
        kafkatemplate.send("registeration-email",e);
    
    }
}

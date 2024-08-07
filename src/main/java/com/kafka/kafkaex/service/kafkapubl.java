package com.kafka.kafkaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkapubl {
    @Autowired
    KafkaTemplate<String,String> template;

    public void message(String msg){
        template.send("tp1",msg).whenComplete((data,ex)->{
            System.out.println("message is "+msg+" and offset is "+data.getRecordMetadata().offset());
        });
    }
}

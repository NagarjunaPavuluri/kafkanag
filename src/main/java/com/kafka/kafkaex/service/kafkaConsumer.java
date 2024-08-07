package com.kafka.kafkaex.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer {

    @KafkaListener(topics="tp1",groupId = "group_id")
    public void readmsg(String msg){
        String s[]=msg.split(",");
        System.out.println("received msg is "+msg);
        System.out.println("received msg is "+s[0]);
        for(int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }
    }
}

package com.kafka.kafkaex.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class kafkaConfig {

    Map<String,Object>prop=new HashMap<>();

    @Bean
    public ProducerFactory<String,String> producerFactory(){
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");//broker server address
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);//converts keys into byte array
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);//converts values into byte array
        return new DefaultKafkaProducerFactory<>(prop);
    }

    @Bean
    public KafkaTemplate<String,String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ConsumerFactory<String,String> consumerFactory(){
        prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        prop.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");//it will create grp with group_id
        prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringSerializer.class);
        prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return new DefaultKafkaConsumerFactory<>(prop);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,String> factory=new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}

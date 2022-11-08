package com.kafkalearn.springbootkafkalearn.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaProducer {

    private  static final Logger LOGGER = LoggerFactory.getLogger(org.apache.kafka.clients.producer.KafkaProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;
    @Value("${spring.kafka.topic.name}")
    private String TOPIC_NAME;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("the message sent %s ",message));
        kafkaTemplate.send(TOPIC_NAME,message);

    }

}

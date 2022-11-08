package com.kafkalearn.springbootkafkalearn.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "topic-example",groupId = "myGroup")
    public void consumeMessage(String message){
        LOGGER.info(String.format("message recived -> %s",message));
    }
}


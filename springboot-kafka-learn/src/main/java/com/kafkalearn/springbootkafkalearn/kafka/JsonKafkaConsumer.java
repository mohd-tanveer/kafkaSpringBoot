package com.kafkalearn.springbootkafkalearn.kafka;

import com.kafkalearn.springbootkafkalearn.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "topic-example_json",groupId = "myGroup")
    public void consumeMessage(User user){
        LOGGER.info(String.format("jason message received -> %s",user.toString()));
    }
}

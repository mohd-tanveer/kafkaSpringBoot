package com.kafkalearn.springbootkafkalearn.kafka;

import com.kafkalearn.springbootkafkalearn.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String,String> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @Value("${spring.kafka.topic-json.name}")
    private String TOPIC_NAME_JSON;
    public void sendMessage(User user){
        LOGGER.info(String.format("the message sent -> %s",user.toString()));
        Message<User> message = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,TOPIC_NAME_JSON).build();
        kafkaTemplate.send(message);
    }
}

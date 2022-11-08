package com.kafkalearn.springbootkafkalearn.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class kafkaTopicConfig {
    @Value("${spring.kafka.topic.name}")
    private String TOPIC_NAME;
    @Value("${spring.kafka.topic-json.name}")
    private String TOPIC_NAME_JSON;

    @Bean
    public NewTopic javaKafkaTopic(){
        return TopicBuilder.name(TOPIC_NAME).build();
    }
    @Bean
    public NewTopic javaKafkaTopicJson(){
        return TopicBuilder.name(TOPIC_NAME_JSON).build();
    }
}

package com.pmso.product_management_system_original.producers;

import com.pmso.product_management_system_original.dataaccess.entities.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;


@Component
public class CategoryProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryProducer.class);
    private static final String TOPIC_NAME = "categories-topic";
    private KafkaTemplate<String, Category> kafkaTemplate;

    public CategoryProducer(KafkaTemplate<String, Category> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Category category) {
        LOGGER.info(String.format("Category => %s", category.toString()));

        Message<Category> message = MessageBuilder
                .withPayload(category)
                .setHeader(KafkaHeaders.TOPIC, TOPIC_NAME)
                .build();
        kafkaTemplate.send(message);
    }

}

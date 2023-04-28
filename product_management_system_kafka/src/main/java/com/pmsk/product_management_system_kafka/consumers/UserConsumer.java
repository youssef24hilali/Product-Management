package com.pmsk.product_management_system_kafka.consumers;

import com.pmsk.product_management_system_kafka.dataaccess.dao.UserKafkaRepository;
import com.pmso.product_management_system_original.dataaccess.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    @Autowired
    private UserKafkaRepository userKafkaRepository;

    @KafkaListener(topics = "users-topic", groupId = "users-consumer")
    public void receive(User user) {
        com.pmsk.product_management_system_kafka.dataaccess.entities.User user1= new com.pmsk.product_management_system_kafka.dataaccess.entities.User();
        user1.setId(user.getId());
        user1.setEmail(user.getEmail());
        user1.setFirstName(user.getFirstName());
        user1.setPassword(user.getPassword());
        user1.setLastName(user.getLastName());
        user1.setRole(user.getRole());
        userKafkaRepository.save(user1);
    }

}

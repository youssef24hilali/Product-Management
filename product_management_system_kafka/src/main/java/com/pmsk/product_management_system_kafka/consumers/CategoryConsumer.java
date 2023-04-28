package com.pmsk.product_management_system_kafka.consumers;

import com.pmsk.product_management_system_kafka.dataaccess.dao.CategoryKafkaRepository;
import com.pmso.product_management_system_original.dataaccess.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CategoryConsumer {

    @Autowired
    private CategoryKafkaRepository categoryKafkaRepository;

    @KafkaListener(topics = "categories-topic", groupId = "categories-consumer")
    public void receive(Category category) {
        com.pmsk.product_management_system_kafka.dataaccess.entities.Category category1 = this.categoryPMSK(category);
        categoryKafkaRepository.save(category1);
    }

    public com.pmsk.product_management_system_kafka.dataaccess.entities.Category categoryPMSK(Category category){
        com.pmsk.product_management_system_kafka.dataaccess.entities.Category category1 = new com.pmsk.product_management_system_kafka.dataaccess.entities.Category();
        category1.setId(category.getId());
        category1.setNom(category.getNom());
        category1.setSlug(category.getSlug());
        category1.setDateCreation(category.getDateCreation());
        category1.setDescription(category.getDescription());
        category1.setDateModification(category.getDateModification());
        category1.setSupprimer(category.getSupprimer());
        return category1;
    }


}

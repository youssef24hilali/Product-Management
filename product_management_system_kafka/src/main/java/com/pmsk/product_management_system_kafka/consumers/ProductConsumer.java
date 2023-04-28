package com.pmsk.product_management_system_kafka.consumers;

import com.pmsk.product_management_system_kafka.dataaccess.dao.ProductKafkaRepository;
import com.pmso.product_management_system_original.dataaccess.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductConsumer {
    @Autowired
    private ProductKafkaRepository productKafkaRepository;

    @KafkaListener(topics = "products-topic", groupId = "products-consumer")
    public void receive(Product product) {
        CategoryConsumer category = new CategoryConsumer();
        com.pmsk.product_management_system_kafka.dataaccess.entities.Product product1 = new com.pmsk.product_management_system_kafka.dataaccess.entities.Product();
        product1.setDateCreation(product.getDateCreation());
        product1.setDescription(product.getDescription());
        product1.setId(product.getId());
        product1.setNom(product.getNom());
        product1.setSupprimer(product.getSupprimer());
        product1.setDateModification(product.getDateModification());
        product1.setSlug(product.getSlug());
        product1.setCategory(category.categoryPMSK(product.getCategory()));
        product1.setImage(product.getImage());
        productKafkaRepository.save(product1);
    }

}

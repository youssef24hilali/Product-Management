package com.pmso.product_management_system_original.dataaccess.dao;

import com.pmso.product_management_system_original.dataaccess.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {
}

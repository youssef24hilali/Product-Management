package com.pmso.product_management_system_original.logic.api;


import com.pmso.product_management_system_original.dataaccess.entities.Category;
import com.pmso.product_management_system_original.to.CategoryDto;

import java.util.List;

public interface CategoryService {

    void addCategory(CategoryDto categoryDto);
    List<CategoryDto> allCategories();
    List<CategoryDto> categories();
    void updateCategory(long id, CategoryDto updatedCategory);
    void deleteCategory(long id);
    void updateDelete(long id);
    int counting();
    CategoryDto getCategoryDto(Category category) ;

    CategoryDto getCategory(Long id);

}

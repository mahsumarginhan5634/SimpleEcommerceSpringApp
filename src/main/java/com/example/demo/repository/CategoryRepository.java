package com.example.demo.repository;

import com.example.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Integer> {

    Category save(Category category);

    Category findCategoryByNameAndDescription(String name,String description);

}

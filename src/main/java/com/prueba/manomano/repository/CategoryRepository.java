package com.prueba.manomano.repository;

import com.prueba.manomano.repository.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryById(Long catId);
}

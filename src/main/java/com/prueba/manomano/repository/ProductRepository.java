package com.prueba.manomano.repository;

import com.prueba.manomano.repository.entities.Category;
import com.prueba.manomano.repository.entities.Product;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByCategorizationTypeAndPriceGreaterThanAndStartDateBeforeAndEndDateAfter(Category categorizationType, Double price, LocalDateTime startDateTime, LocalDateTime endDateTime);

    default List<Product> findProductsByCategorizationTypeAndPriceGreaterThanAndStartDateBeforeAndEndDateAfter(Category categorizationType, Double price, LocalDateTime localDateTime) {
        return findProductsByCategorizationTypeAndPriceGreaterThanAndStartDateBeforeAndEndDateAfter(categorizationType, price, localDateTime, localDateTime);
    }
}

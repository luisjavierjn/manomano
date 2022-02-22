package com.prueba.manomano.service;

import com.prueba.manomano.controller.dto.ProductDTO;
import com.prueba.manomano.model.ProductResponseList;
import com.prueba.manomano.repository.CategoryRepository;
import com.prueba.manomano.repository.ProductRepository;
import com.prueba.manomano.repository.entities.Category;
import com.prueba.manomano.repository.entities.Product;
import com.prueba.manomano.service.mapper.ProductServiceMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    CategoryRepository categoryRepository;
    ProductRepository productRepository;
    ProductServiceMapper productServiceMapper;

    @Autowired
    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, ProductServiceMapper productServiceMapper) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.productServiceMapper = productServiceMapper;
    }

    public ProductResponseList applyFilter(ProductDTO productDTO) {
        Category category = categoryRepository.findCategoryById(productDTO.getCatId());
        List<Product> productList = productRepository.findProductsByCategorizationTypeAndPriceGreaterThanAndStartDateBeforeAndEndDateAfter(
                category, productDTO.getMinPrice(), LocalDateTime.parse(productDTO.getDiscountExpDate()));
        ProductResponseList productResponseList = new ProductResponseList();
        productResponseList.categorizationType(category.getId().intValue());
        productResponseList.description(category.getDesc());
        productResponseList.setProducts(productServiceMapper.getListEntityToProductResponseList(productList));
        return productResponseList;
    }
}

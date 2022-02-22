package com.prueba.manomano.service;

import com.prueba.manomano.controller.dto.ProductDTO;
import com.prueba.manomano.model.ProductResponseList;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductResponseList applyFilter(ProductDTO pdto) {
        System.out.println(pdto);
        ProductResponseList productResponseList = new ProductResponseList();
        return productResponseList;
    }
}

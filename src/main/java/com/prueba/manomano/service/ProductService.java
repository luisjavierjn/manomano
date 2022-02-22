package com.prueba.manomano.service;

import com.prueba.manomano.controller.dto.ProductDTO;
import com.prueba.manomano.model.ProductResponseList;

public interface ProductService {

    ProductResponseList applyFilter(ProductDTO productDTO);

}

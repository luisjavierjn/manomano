package com.prueba.manomano.controller;

import com.prueba.manomano.api.ProductsApi;
import com.prueba.manomano.controller.dto.ProductDTO;
import com.prueba.manomano.model.ProductResponseList;
import com.prueba.manomano.service.ProductService;
import io.swagger.annotations.ApiParam;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductsApi {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<ProductResponseList> getProducts(
            @ApiParam(value = "", required = true) @PathVariable("catId") String catId,
            @ApiParam(value = "", required = true) @PathVariable("minPrice") BigDecimal minPrice,
            @NotNull @Valid String discountExpDate) {

        ProductResponseList productResponseList =
                productService.applyFilter(ProductDTO.builder()
                        .catId(catId)
                        .minPrice(minPrice.doubleValue())
                        .discountExpDate(discountExpDate)
                        .build()
                );

        return new ResponseEntity<>(productResponseList, HttpStatus.OK);
    }
}


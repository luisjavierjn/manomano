package com.prueba.manomano.controller;

import com.prueba.manomano.api.ProductsApi;
import com.prueba.manomano.model.ProductResponseList;
import io.swagger.annotations.ApiParam;
import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.PathVariable;

public class ProductController implements ProductsApi {

    @Override
    public ResponseEntity<ProductResponseList> getProducts(
            @ApiParam(value = "", required = true) @PathVariable("catId") String catId,
            @ApiParam(value = "", required = true) @PathVariable("minPrice") BigDecimal minPrice,
            @NotNull @Valid String discountExpDate) {
        return null;
    }
}


package com.prueba.manomano.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    Long catId;
    Double minPrice;
    String discountExpDate;
}

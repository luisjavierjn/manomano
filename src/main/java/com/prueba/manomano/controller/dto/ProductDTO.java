package com.prueba.manomano.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    String catId;
    Double minPrice;
    String discountExpDate;
}

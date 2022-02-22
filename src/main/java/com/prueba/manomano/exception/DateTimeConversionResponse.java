package com.prueba.manomano.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DateTimeConversionResponse  {
    String message;
    String code;
}

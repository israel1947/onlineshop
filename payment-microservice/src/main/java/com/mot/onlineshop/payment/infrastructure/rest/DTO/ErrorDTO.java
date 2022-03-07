package com.mot.onlineshop.payment.infrastructure.rest.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private String code;
    private String message;
}

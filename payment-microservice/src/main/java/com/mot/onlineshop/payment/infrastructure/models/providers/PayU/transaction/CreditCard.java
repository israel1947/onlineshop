package com.mot.onlineshop.payment.infrastructure.models.providers.PayU.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreditCard {
    private String number;
    private String securityCode;
    private String expirationDate;
    private String name;
}

package com.mot.onlineshop.payment.infrastructure.rest.models.transacction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AdditionalValues {
    TX TX_VALUE;
    TX TX_TAX;
    TX TX_TAX_RETURN_BASE;
}

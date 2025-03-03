package com.mot.onlineshop.payment.infrastructure.mappers;

import com.mot.onlineshop.payment.infrastructure.transform.PaymentTransform;
import com.mot.onlineshop.payment.infrastructure.models.shared.Payload;
import org.springframework.stereotype.Component;

@Component
public class PayloadMapper {

    private PaymentTransform paymentTransform = PaymentTransform.builder().build();

    public Payload map(String value){
        return (Payload) paymentTransform.transformPaymentStringToObject(value, new Payload());
    }

    public String map(Payload payload){
        if (payload!=null) return payload.getOrderId();
        return null;
    }

}

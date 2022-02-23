package com.mot.onlineshop.payment.domain.persistence_ports;

import com.mot.onlineshop.payment.domain.models.Payment;
import com.mot.onlineshop.payment.domain.models.PaymentId;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PaymentPersistence {
    Stream<Payment> findAll();
}
package com.mot.onlineshop.payment.infrastructure.mappers;

import com.mot.onlineshop.payment.domain.models.payment.Payment;
import com.mot.onlineshop.payment.infrastructure.persistence.entities.PaymentEntity;
import com.mot.onlineshop.payment.infrastructure.rest.api.DTOs.CreatePaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {CreatePaymentRequestMapper.class, CreatePaymentResponseMapper.class, PaymentReferenceMapper.class, DatetimePaymentMapper.class, PayloadMapper.class})
public interface PaymentMapper {

   CreatePaymentDTO paymentEntitytoDto(PaymentEntity entity);
   @Mapping(ignore = true, target = "id")
   PaymentEntity paymentDtoToEntity (CreatePaymentDTO paymentDTO);

   @Mapping(ignore = true,target = "datetimePayment")
   Payment paymentDtoToPayment(CreatePaymentDTO createPaymentDTO);

   CreatePaymentDTO paymentToPaymentDto(Payment payment);

   @Mapping(ignore = true, target = "id")
   Payment paymentEntityToPayment(PaymentEntity paymentEntity);

//   @Mapping(ignore = true, target = "requestMessage")
//   @Mapping(ignore = true, target = "responseMessage")
   PaymentEntity paymentToPaymentEntity(Payment payment);
}

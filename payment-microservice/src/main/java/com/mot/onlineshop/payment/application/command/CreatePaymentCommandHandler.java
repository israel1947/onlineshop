package com.mot.onlineshop.payment.application.command;

import com.mot.onlineshop.payment.application.commandbus.CommandHandler;
import com.mot.onlineshop.payment.application.usecases.CreatePaymentUseCase;
import com.mot.onlineshop.payment.domain.interfaces.EventRepository;
import com.mot.onlineshop.payment.domain.models.event.EventId;
import com.mot.onlineshop.payment.domain.models.payment.PaymentId;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Component @AllArgsConstructor @NoArgsConstructor
public class CreatePaymentCommandHandler implements CommandHandler<CreatePaymentCommand> {
    private CreatePaymentUseCase useCase;
    private EventRepository eventRepository;

    private static final Logger log = LogManager.getLogger(CreatePaymentCommandHandler.class);

    @Override
    public void handle(CreatePaymentCommand command) throws Exception {
        String methodSignature = "Inicializando método handle en CreatePaymentCommandHandler";
        log.info(methodSignature);
        PaymentId paymentId = command.getPayment().getPaymentReference();
        command.getPayment().getPaymentReference().setId(UUID.randomUUID());
        command.getPayment().setDatetimePayment(LocalDateTime.now(ZoneId.of("UTC")).minusHours(5L));
        EventId eventId = eventRepository.getId();
        command.setPayment(useCase.handle(eventId, command.getPayment()));


    }
}

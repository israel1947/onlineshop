package com.mot.onlineshop.payment.application.query;

import com.mot.onlineshop.payment.application.constants.AppPaymentConstants;
import com.mot.onlineshop.payment.application.querybus.QueryHandler;
import com.mot.onlineshop.payment.application.usecases.GetPaymentUseCase;
import com.mot.onlineshop.payment.domain.models.payment.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class GetPaymentQueryHandler implements QueryHandler<Payment, GetPaymentQuery> {
    private GetPaymentUseCase useCase;

    public GetPaymentQueryHandler(GetPaymentUseCase useCase) {
        this.useCase = useCase;
    }

    private static Logger log = LogManager.getLogger(GetPaymentQueryHandler.class);

    @Override
    public Payment handle(GetPaymentQuery query) throws Exception {
        String methodSignature = "Inicializando método handle en GetPaymentQueryHandler";
        log.debug(methodSignature);
        log.info(AppPaymentConstants.EXECUTING_QUERY_HANDLER +"GetPaymentQueryHandler");
        return useCase.handle(query.getPayment());
    }
}

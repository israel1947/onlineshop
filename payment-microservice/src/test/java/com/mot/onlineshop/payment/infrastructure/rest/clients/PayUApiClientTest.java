package com.mot.onlineshop.payment.infrastructure.rest.clients;

import com.mot.onlineshop.payment.domain.interfaces.IPaymentRequest;
import com.mot.onlineshop.payment.domain.interfaces.IPaymentResponse;
import com.mot.onlineshop.payment.infrastructure.rest.DAOS.RequestPayURetrofitDAO;
import com.mot.onlineshop.payment.infrastructure.rest.constants.PaymentConstants;
import com.mot.onlineshop.payment.infrastructure.rest.mappers.PaymentMapper;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayURequest;
import com.mot.onlineshop.payment.infrastructure.rest.models.PayUResponse;
import com.mot.onlineshop.payment.infrastructure.rest.models.transactionresponse.TransactionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class PayUApiClientTest {

    @Mock
    private RequestPayURetrofitDAO requestPayURetrofitDAO;

    @InjectMocks
    private PayUApiClient payUApiClient;

    private PayURequest payURequest;

    private PayUResponse payUResponse;

    private Call<PayUResponse> payUResponseCall;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        PaymentMapper paymentTransform = PaymentMapper.builder()
                .build();
        payUResponse = (PayUResponse) paymentTransform.transformPaymentStringToObject(
                PaymentConstants.PAYMENTRESPONSE,
                new PayUResponse()
        );
         payURequest = (PayURequest) paymentTransform.transformPaymentStringToObject(
                PaymentConstants.PAYMENTREQUEST,
                new PayURequest()
        );
        System.out.println("payURequest:"+payURequest);
        System.out.println("payUResponse:"+payUResponse);

    }

    @Test
    void sendRequestPayU() throws IOException {
     // when(requestPayURetrofitDAO.postRequestPayU(payURequest)).thenReturn((Call<PayUResponse>) payUResponse);
        PayUResponse payUResponseT = (PayUResponse) payUApiClient.sendRequestPayU(payURequest);
        assertNotNull(payUResponseT);
        assertEquals(payUResponse, payUResponseT);
    }
}
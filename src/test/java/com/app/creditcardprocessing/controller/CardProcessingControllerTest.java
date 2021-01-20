package com.app.creditcardprocessing.controller;

import com.app.creditcardprocessing.entity.CardDetails;
import com.app.creditcardprocessing.exception.RestServiceException;
import com.app.creditcardprocessing.service.CardDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class CardProcessingControllerTest {

    @InjectMocks
    private CardProcessingController cardProcessingController;

    @MockBean
    private CardDetailsService cardDetailsService;

    public CardProcessingControllerTest() {
        cardProcessingController = new CardProcessingController(cardDetailsService);
    }

    @Test
    void test_listAllCards() {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setName("test");
        cardDetails.setCardNumber("79927398713");
        cardDetails.setCreditLimit(1234.00);
        cardDetails.setCreditBalance(0.00);

        List<CardDetails> list = new ArrayList<>();
        list.add(cardDetails);

        Mockito.doReturn(list).when(cardDetailsService).fetchAllCards();

        List<CardDetails> response = cardProcessingController.listAllCards();
        assertNotNull(response);
        assertEquals(response.size(), 1);
    }

    @Test
    void test_add_invalid_CreditCard() {

        CardDetails cardDetails = new CardDetails();
        cardDetails.setName("test");
        cardDetails.setCardNumber("79927398713244");
        cardDetails.setCreditLimit(null);
        cardDetails.setCreditBalance(null);

        Mockito.doReturn(cardDetails).when(cardDetailsService).addCard(Mockito.any(CardDetails.class));

        CardDetails response = cardProcessingController.addCreditCard(cardDetails);
        assertNotNull(response);
        assertEquals(response.getName(), "test");
    }

    @Test
    void test_add_invalid_CreditCard_already_registered() {

        CardDetails cardDetails = new CardDetails();
        cardDetails.setName("test");
        cardDetails.setCardNumber("79927398713244");
        cardDetails.setCreditLimit(null);
        cardDetails.setCreditBalance(null);

        Mockito.doReturn(true)
                .when(cardDetailsService).isCardRegistered(Mockito.anyString());

        assertThrows(RestServiceException.class,
                ()->cardProcessingController.addCreditCard(cardDetails));
    }
}

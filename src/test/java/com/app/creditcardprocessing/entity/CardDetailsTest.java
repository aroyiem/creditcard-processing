package com.app.creditcardprocessing.entity;

import org.junit.jupiter.api.Test;
import org.springframework.util.SerializationUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardDetailsTest {

    private CardDetails cardDetails;

    public CardDetailsTest() {
        cardDetails = new CardDetails();
        cardDetails.setName("Test User");
        cardDetails.setCardNumber("4111111111111111");
        cardDetails.setCreditLimit(200.01d);
    }

    @Test
    public void beanIsSerializable() {
        final byte[] serializedBean = SerializationUtils.serialize(cardDetails);
        final CardDetails resultBean = (CardDetails)SerializationUtils.deserialize(serializedBean);
        assertEquals(cardDetails, resultBean);
    }
}

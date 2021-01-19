package com.app.creditcardprocessing.service;

import com.app.creditcardprocessing.entity.CardDetails;

import java.util.List;

public interface CardDetailsService {
    List<CardDetails> fetchAllCards();

    CardDetails addCard(CardDetails cardDetails);

    Boolean isCardRegistered(String cardNumber);
}

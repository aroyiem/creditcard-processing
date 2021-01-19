package com.app.creditcardprocessing.service;

import com.app.creditcardprocessing.entity.CardDetails;

import java.util.List;

public interface CardDetailsService {
    List<CardDetails> fetchAllCards();
}

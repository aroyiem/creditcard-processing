package com.app.creditcardprocessing.controller;

import com.app.creditcardprocessing.entity.CardDetails;
import com.app.creditcardprocessing.service.CardDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardProcessingController {

    private CardDetailsService cardDetailsService;

    @Autowired
    public CardProcessingController(CardDetailsService cardDetailsService) {
        this.cardDetailsService = cardDetailsService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public List<CardDetails> listAllCards() {
        return cardDetailsService.fetchAllCards();
    }
}

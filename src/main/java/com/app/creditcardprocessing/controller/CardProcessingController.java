package com.app.creditcardprocessing.controller;

import com.app.creditcardprocessing.entity.CardDetails;
import com.app.creditcardprocessing.exception.RestServiceException;
import com.app.creditcardprocessing.service.CardDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public CardDetails addCreditCard(@Valid @RequestBody CardDetails cardDetails) {
        if(cardDetailsService.isCardRegistered(cardDetails.getCardNumber())) {
            throw new RestServiceException("Card already registered in the system");
        }
        return cardDetailsService.addCard(cardDetails);
    }

}

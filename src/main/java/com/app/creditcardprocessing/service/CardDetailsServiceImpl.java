package com.app.creditcardprocessing.service;

import com.app.creditcardprocessing.dao.CardDetailsDao;
import com.app.creditcardprocessing.entity.CardDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
public class CardDetailsServiceImpl implements CardDetailsService{

    private CardDetailsDao cardDetailsDao;

    @Autowired
    public CardDetailsServiceImpl(CardDetailsDao cardDetailsDao) {
        this.cardDetailsDao = cardDetailsDao;
    }

    @Override
    public List<CardDetails> fetchAllCards() {
        return cardDetailsDao.findAll();
    }

    @Override
    public CardDetails addCard(CardDetails cardDetails) {
        cardDetails.setCreditBalance(0.0d);
        return cardDetailsDao.save(cardDetails);
    }

    @Override
    public Boolean isCardRegistered(String cardNumber) {
        CardDetails cardDetails = cardDetailsDao.findByCardNumber(cardNumber);
        return (null == cardDetails);
    }
}

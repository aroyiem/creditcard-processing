package com.app.creditcardprocessing.service;

import com.app.creditcardprocessing.dao.CardDetailsDao;
import com.app.creditcardprocessing.entity.CardDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class CardDetailsServiceImplTest {


    @MockBean
    private CardDetailsDao cardDetailsDao;

    @InjectMocks
    private CardDetailsServiceImpl cardDetailsService;

    @BeforeEach
    public void setUp() {
        cardDetailsService = new CardDetailsServiceImpl(cardDetailsDao);
    }


    @Test
    public void test_fetchAllCards() {

        CardDetails cardDetails = new CardDetails();
        cardDetails.setName("test");
        cardDetails.setCardNumber("79927398713");
        cardDetails.setCreditLimit(1234.00);
        cardDetails.setCreditBalance(0.00);

        List<CardDetails> list = new ArrayList<>();
        list.add(cardDetails);

        Mockito.doReturn(list).when(cardDetailsDao).findAll();


        List<CardDetails> result = cardDetailsService.fetchAllCards();
        assertNotNull(result);
        assertEquals(result.size(), 1);
    }

    @Test
    public void test_addcard() {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setName("test");
        cardDetails.setCardNumber("79927398713");
        Mockito.doReturn(cardDetails).when(cardDetailsDao).save(Mockito.any(CardDetails.class));

        CardDetails result = cardDetailsService.addCard(cardDetails);
        assertNotNull(result);
        assertEquals(result.getCardNumber(), "79927398713");
    }


    @Test
    void test_isCardRegistered_test1() {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setName("test");
        cardDetails.setCardNumber("79927398713");
        Mockito.doReturn(cardDetails).when(cardDetailsDao).findByCardNumber(Mockito.anyString());

        Boolean isRegistered = cardDetailsService.isCardRegistered("79927398713");

        assertEquals(isRegistered, true);
    }

    @Test
    void test_isCardRegistered_test2() {

        Mockito.doReturn(null).when(cardDetailsDao).findByCardNumber(Mockito.anyString());
        Boolean isRegistered = cardDetailsService.isCardRegistered("79927398713");
        assertEquals(isRegistered, false);
    }
}

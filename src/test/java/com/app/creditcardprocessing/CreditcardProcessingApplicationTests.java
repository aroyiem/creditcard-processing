package com.app.creditcardprocessing;

import com.app.creditcardprocessing.dao.CardDetailsDao;
import com.app.creditcardprocessing.entity.CardDetails;
import com.app.creditcardprocessing.exception.RestServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class CreditcardProcessingApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CardDetailsDao cardDetailsDao;

    @Test
    void test_addValidCreditCard_and_add_duplicate_card() throws Exception {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setName("Test User");
        cardDetails.setCardNumber("4111111111111111");
        cardDetails.setCreditLimit(200.01d);

        mockMvc.perform(
                post("/api/cards/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(cardDetails)))
                .andExpect(status().isOk());

        CardDetails cardDetails1 = cardDetailsDao.findByCardNumber("4111111111111111");
        assertEquals(cardDetails1.getCardNumber(), "4111111111111111");

        mockMvc.perform(
                post("/api/cards/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(cardDetails)))
                .andExpect(status().isBadRequest())
                .andExpect(result->
                        assertTrue(result.getResolvedException() instanceof RestServiceException));
    }

    @Test
    void test_listAllCards() throws Exception {
        mockMvc.perform(get("/api/cards").contentType("application/json"))
                .andExpect(status().isOk());

        List<CardDetails> list = cardDetailsDao.findAll();
        assertEquals(list.size(), 1);

    }

    @Test
    void test_invalidCardDetails() throws Exception {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setName("Test User");
        cardDetails.setCardNumber("411111111111111111");
        cardDetails.setCreditLimit(200.01d);

        mockMvc.perform(
                post("/api/cards/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(cardDetails)))
                .andExpect(status().isBadRequest())
                .andExpect(result ->
                        assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException)
                );
    }

}

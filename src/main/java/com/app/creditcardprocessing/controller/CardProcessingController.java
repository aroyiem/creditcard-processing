package com.app.creditcardprocessing.controller;

import com.app.creditcardprocessing.entity.CardDetails;
import com.app.creditcardprocessing.exception.RestServiceException;
import com.app.creditcardprocessing.service.CardDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
@Api(value = "Credit Card Processing")
public class CardProcessingController {

    private CardDetailsService cardDetailsService;

    @Autowired
    public CardProcessingController(CardDetailsService cardDetailsService) {
        this.cardDetailsService = cardDetailsService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    @ApiOperation("View the list of all credit cards")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successfully retrieved list"),
                    @ApiResponse(code = 400, message = "Bad Request")
            }
    )
    public List<CardDetails> listAllCards() {
        return cardDetailsService.fetchAllCards();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    @ApiOperation("Add new credit card")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successfully retrieved list"),
                    @ApiResponse(code = 400, message = "Bad Request")
            }
    )
    public CardDetails addCreditCard(@Valid @RequestBody CardDetails cardDetails) {
        if(cardDetailsService.isCardRegistered(cardDetails.getCardNumber())) {
            throw new RestServiceException("Card already registered in the system");
        }
        return cardDetailsService.addCard(cardDetails);
    }

}

package com.app.creditcardprocessing.entity;

import com.app.creditcardprocessing.validators.CreditCardNumberConstraint;
import com.app.creditcardprocessing.validators.DecimalValidatorConstraint;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Data
@Entity
@Table(name = "carddetails")
public class CardDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;

    @Column(name = "name")
    @NotNull(message = "Name is required")
    private String name;

    @Column(name = "cardnumber")
    @NotNull(message = "Card Number is required")
    @Pattern(message = "Card number has to be numeric", regexp = "^[0-9]+$")
    @Length(max = 19, message = "Card number must not exceed 19")
    @CreditCardNumberConstraint(message = "Invalid card number")
    private String cardNumber;

    @Column(name = "creditlimit")
    @NotNull(message = "Credit Limit is required")
    @DecimalValidatorConstraint(message = "Only 2 decimal places is allowed")
    private Double creditLimit;

    @Column(name = "creditbalance")
    @DecimalValidatorConstraint(message = "Only 2 decimal place is allowed")
    private Double creditBalance;

}

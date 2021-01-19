package com.app.creditcardprocessing.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
    private String cardNumber;

    @Column(name = "creditlimit")
    @NotNull(message = "Credit Limit is required")
    private Double creditLimit;

    @Column(name = "balance")
    private Double balance;
}

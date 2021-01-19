package com.app.creditcardprocessing.dao;

import com.app.creditcardprocessing.entity.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDetailsDao extends JpaRepository<CardDetails, Integer> {


}

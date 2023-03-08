package com.afonsoqueiros.springbootinduction.visacardsapi.repository;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisaCardRepository extends JpaRepository<VisaCard, Long> {

}
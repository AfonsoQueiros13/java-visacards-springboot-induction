package com.afonsoqueiros.springbootinduction.visacardsapi;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestH2Repository extends JpaRepository<VisaCard, Long> {
}

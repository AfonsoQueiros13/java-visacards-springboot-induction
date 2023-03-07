package com.afonsoqueiros.springbootinduction.visacardsapi.repository;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface VisaCardRepository extends JpaRepository<VisaCard, Long> {

    VisaCard fingById(Long id);

}
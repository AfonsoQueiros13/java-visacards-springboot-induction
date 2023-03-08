package com.afonsoqueiros.springbootinduction.visacardsapi.domain.services;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.repository.VisaCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@Component
public class VisaCardService {
    @Autowired
    private VisaCardRepository visaCardRepository;

    public Optional<VisaCard> findById(Long id){

        return visaCardRepository.findById(id);

    }
}

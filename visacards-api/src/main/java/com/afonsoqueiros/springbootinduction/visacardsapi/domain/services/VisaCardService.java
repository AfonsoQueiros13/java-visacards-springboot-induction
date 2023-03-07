package com.afonsoqueiros.springbootinduction.visacardsapi.domain.services;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.repository.VisaCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class VisaCardService {
    @Autowired
    private VisaCardRepository visaCardRepository;

    @Autowired
    public VisaCardService(VisaCardRepository visaCardRepository) {

        this.visaCardRepository = visaCardRepository;
    }

    public VisaCard fingById(Long id){
        return this.visaCardRepository.fingById(id);
    }
}

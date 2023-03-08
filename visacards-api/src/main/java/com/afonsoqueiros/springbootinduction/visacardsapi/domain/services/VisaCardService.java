package com.afonsoqueiros.springbootinduction.visacardsapi.domain.services;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.GetVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.repository.VisaCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisaCardService {
    @Autowired
    private VisaCardRepository visaCardRepository;

    public GetVisaCard findById(Long id){
        Optional<VisaCard> visaCard = this.visaCardRepository.findById(id);

        return VisaCardMapper.INSTANCE.mapVisaCardToGetVisaCard(visaCard);
    }

    public boolean createVisaCard(CreateVisaCard createVisaCard){

        VisaCard visaCard = VisaCardMapper.INSTANCE.mapCreateVisaCardToVisaCard(Optional.ofNullable(createVisaCard));
        this.visaCardRepository.save(visaCard);

        return true;
    }

    public boolean deleteVisaCard(Long id){
        this.visaCardRepository.deleteById(id);
        return true;
    }
}

package com.afonsoqueiros.springbootinduction.visacardsapi.domain.services;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.GetVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.UpdateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.repository.VisaCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public GetVisaCard createVisaCard(CreateVisaCard createVisaCard){

        VisaCard visaCard = VisaCardMapper.INSTANCE.mapCreateVisaCardToVisaCard(createVisaCard);
            if(visaCardRepository.findVisaCardByCardNumber(visaCard.getCardNumber()) == null){
                long id;
                id = this.visaCardRepository.saveAndFlush(visaCard).getId();
                return VisaCardMapper.INSTANCE.mapVisaCardToGetVisaCard(this.visaCardRepository.findById(id));
            }
        return null;
    }

    public ResponseEntity<Object> updateVisaCard(UpdateVisaCard updateVisaCard, Long id){

        Optional<VisaCard> visaCardToUpdate = this.visaCardRepository.findById(id);
        if(visaCardToUpdate.isPresent()){
            VisaCard visaCard = VisaCardMapper.INSTANCE.mapUpdateVisaCardToVisaCard(Optional.ofNullable(updateVisaCard),visaCardToUpdate);
            this.visaCardRepository.save(visaCard);
        }
        return ResponseEntity.notFound().build();
    }

    public Optional<VisaCard> deleteVisaCard(Long id){
        Optional<VisaCard> visaCardToDelete = this.visaCardRepository.findById(id);
        this.visaCardRepository.deleteById(id);
        return visaCardToDelete;
    }

}

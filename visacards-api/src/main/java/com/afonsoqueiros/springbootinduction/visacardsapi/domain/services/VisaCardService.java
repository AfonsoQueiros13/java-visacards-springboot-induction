package com.afonsoqueiros.springbootinduction.visacardsapi.domain.services;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.GetVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.UpdateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.exceptions.GlobalExceptions;
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

    public Long createVisaCard(CreateVisaCard createVisaCard){

        VisaCard visaCard = VisaCardMapper.INSTANCE.mapCreateVisaCardToVisaCard(Optional.ofNullable(createVisaCard));
        if(visaCard != null){
            if(this.visaCardRepository.findVisaCardByCardNumber(visaCard.getCardNumber())!= null){
                throw new GlobalExceptions.ResourceAlreadyOnDBException();
            }
            else{
                this.visaCardRepository.save(visaCard);
                return visaCard.getId();
            }
        }
        else {
            throw new GlobalExceptions.PayloadInvalidException();
        }
    }

    public void updateVisaCard(UpdateVisaCard updateVisaCard, Long id){

        Optional<VisaCard> visaCardToUpdate = this.visaCardRepository.findById(id);
        if(visaCardToUpdate.isPresent()){
            VisaCard visaCard = VisaCardMapper.INSTANCE.mapUpdateVisaCardToVisaCard(Optional.ofNullable(updateVisaCard),visaCardToUpdate);
            this.visaCardRepository.save(visaCard);
        }
        else{
            throw new GlobalExceptions.ResourceNotFoundException();
        }
    }

    public void deleteVisaCard(Long id){
        Optional<VisaCard> visaCardToDelete = this.visaCardRepository.findById(id);
        if(visaCardToDelete.isPresent()){
            this.visaCardRepository.deleteById(id);
        }
        else{
            throw new GlobalExceptions.ResourceNotFoundException();
        }
    }

}

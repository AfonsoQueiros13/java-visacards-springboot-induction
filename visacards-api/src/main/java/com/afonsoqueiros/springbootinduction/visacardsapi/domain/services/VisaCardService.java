package com.afonsoqueiros.springbootinduction.visacardsapi.domain.services;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.GetVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.UpdateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.exceptions.ResourceAlreadyAddedException;
import com.afonsoqueiros.springbootinduction.visacardsapi.exceptions.ResourceNotFoundException;
import com.afonsoqueiros.springbootinduction.visacardsapi.repository.VisaCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisaCardService {
    @Autowired
    private VisaCardRepository visaCardRepository;

    public GetVisaCard findById(Long id) throws ResourceNotFoundException {
        Optional<VisaCard> visaCard = this.visaCardRepository.findById(id);
        if(visaCard.isEmpty()){
                throw new ResourceNotFoundException("VisaCard with this ID not exists");
            }
        else{
            return VisaCardMapper.INSTANCE.mapVisaCardToGetVisaCard(visaCard);
        }
    }

    public GetVisaCard createVisaCard(CreateVisaCard createVisaCard) throws ResourceAlreadyAddedException {
        long id;
        if(visaCardRepository.findVisaCardByCardNumber(createVisaCard.getCardNumber()) == null){
            VisaCard visaCard = VisaCardMapper.INSTANCE.mapCreateVisaCardToVisaCard(createVisaCard);
            id = this.visaCardRepository.saveAndFlush(visaCard).getId();
                return VisaCardMapper.INSTANCE.mapVisaCardToGetVisaCard(this.visaCardRepository.findById(id));
            }
            else{
                throw new ResourceAlreadyAddedException("VisaCard with this number already added ");
            }
    }

    public void updateVisaCard(UpdateVisaCard updateVisaCard, Long id) throws ResourceNotFoundException {

        Optional<VisaCard> visaCardToUpdate = this.visaCardRepository.findById(id);
        if(visaCardToUpdate.isEmpty()){
            throw new ResourceNotFoundException("VisaCard with this ID not exists");
        }
        else{
            VisaCard visaCard = VisaCardMapper.INSTANCE.mapUpdateVisaCardToVisaCard(Optional.ofNullable(updateVisaCard),visaCardToUpdate);
            this.visaCardRepository.save(visaCard);
        }
    }

    public void deleteVisaCard(Long id) throws ResourceNotFoundException {
        Optional<VisaCard> visaCardToDelete = this.visaCardRepository.findById(id);

        if(visaCardToDelete.isEmpty()){
            throw new ResourceNotFoundException("VisaCard with this ID not exists");
        }
        else{
            this.visaCardRepository.deleteById(id);
        }

    }

}

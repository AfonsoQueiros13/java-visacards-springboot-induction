package com.afonsoqueiros.springbootinduction.visacardsapi.domain.services;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.GetVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.UpdateVisaCard;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class VisaCardMapperImpl implements VisaCardMapper {
    @Override
    public GetVisaCard mapVisaCardToGetVisaCard(Optional<VisaCard> visaCardOptional) {

        VisaCard visaCard = visaCardOptional.orElse(null);
        if(visaCard == null)
            return null;

        GetVisaCard getVisaCard = new GetVisaCard();
        getVisaCard.setId(visaCard.getId());
        getVisaCard.setCardNumber(visaCard.getCardNumber());
        getVisaCard.setAddress(visaCard.getAddress());
        getVisaCard.setCreatedDate(visaCard.getCreatedDate().toString());
        getVisaCard.setExpireDate(visaCard.getExpireDate());
        getVisaCard.setFirstName(visaCard.getFirstName());
        getVisaCard.setLastName(visaCard.getLastName());
        getVisaCard.setPhoneNumber(visaCard.getPhoneNumber());
        getVisaCard.setUpdatedDate(visaCard.getUpdateDate().toString());
        return getVisaCard;
    }

    @Override
    public VisaCard mapCreateVisaCardToVisaCard(Optional<CreateVisaCard> createVisaCardOptional) {


        CreateVisaCard createVisaCard = createVisaCardOptional.orElse(null);
        if(createVisaCard == null)
            return null;

        VisaCard visaCard = new VisaCard();
        visaCard.setCardNumber(createVisaCard.getCardNumber());
        visaCard.setAddress(createVisaCard.getAddress());
        visaCard.setCreatedDate(LocalDateTime.now());
        visaCard.setExpireDate(createVisaCard.getExpireDate());
        visaCard.setFirstName(createVisaCard.getFirstName());
        visaCard.setLastName(createVisaCard.getLastName());
        visaCard.setPhoneNumber(createVisaCard.getPhoneNumber());
        visaCard.setUpdatedDate(LocalDateTime.now());
        return visaCard;
    }

    @Override
    public VisaCard mapUpdateVisaCardToVisaCard(UpdateVisaCard updateVisaCard) {
        return null;
    }

}

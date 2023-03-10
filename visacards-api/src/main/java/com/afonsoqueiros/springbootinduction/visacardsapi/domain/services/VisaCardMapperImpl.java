package com.afonsoqueiros.springbootinduction.visacardsapi.domain.services;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.GetVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.UpdateVisaCard;

import io.micrometer.common.util.StringUtils;

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
        visaCard.setCvv(createVisaCard.getCvv());
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
    public VisaCard mapUpdateVisaCardToVisaCard(Optional<UpdateVisaCard> updateVisaCardOptional,Optional<VisaCard> visaCardToUpdateOptional ) {

        UpdateVisaCard updateVisaCard = updateVisaCardOptional.orElse(null);
        if(updateVisaCard == null)
            return null;

        VisaCard visaCardToUpdate = visaCardToUpdateOptional.orElse(null);
        if(visaCardToUpdate == null)
            return null;

        if(!StringUtils.isEmpty(updateVisaCard.getAddress()))
            visaCardToUpdate.setAddress(updateVisaCard.getAddress());

        if(!StringUtils.isEmpty(updateVisaCard.getLastName()))
            visaCardToUpdate.setLastName(updateVisaCard.getLastName());

        if(!StringUtils.isEmpty(updateVisaCard.getPhoneNumber()))
            visaCardToUpdate.setPhoneNumber(updateVisaCard.getPhoneNumber());

        visaCardToUpdate.setUpdatedDate(LocalDateTime.now());
        return visaCardToUpdate;
    }

}

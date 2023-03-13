package com.afonsoqueiros.springbootinduction.visacardsapi.domain.services;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.GetVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.UpdateVisaCard;

import io.micrometer.common.util.StringUtils;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.text.SimpleDateFormat;
@Component
public class VisaCardMapperImpl implements VisaCardMapper {

    DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public GetVisaCard mapVisaCardToGetVisaCard(Optional<VisaCard> visaCardOptional) {

        VisaCard visaCard = visaCardOptional.orElse(null);
        if(visaCard == null)
            return null;

        GetVisaCard getVisaCard = new GetVisaCard();
        getVisaCard.setId(visaCard.getId());
        getVisaCard.setCardNumber(visaCard.getCardNumber());
        getVisaCard.setAddress(visaCard.getAddress());
        getVisaCard.setCreatedDate(visaCard.getCreatedDate().format(dft));
        getVisaCard.setExpireDate(visaCard.getExpireDate());
        getVisaCard.setFirstName(visaCard.getFirstName());
        getVisaCard.setLastName(visaCard.getLastName());
        getVisaCard.setPhoneNumber(visaCard.getPhoneNumber());
        getVisaCard.setUpdatedDate(visaCard.getUpdateDate().format(dft));
        return getVisaCard;
    }

    @Override
    public VisaCard mapCreateVisaCardToVisaCard(CreateVisaCard createVisaCard) {


        VisaCard visaCard = new VisaCard();
        visaCard.setCardNumber(createVisaCard.getCardNumber());
        visaCard.setCvv(createVisaCard.getCvv());
        visaCard.setAddress(createVisaCard.getAddress());
        visaCard.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());
        visaCard.setExpireDate(createVisaCard.getExpireDate());
        visaCard.setFirstName(createVisaCard.getFirstName());
        visaCard.setLastName(createVisaCard.getLastName());
        visaCard.setPhoneNumber(createVisaCard.getPhoneNumber());
        visaCard.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());
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

        visaCardToUpdate.setUpdateDate(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());
        return visaCardToUpdate;
    }

}

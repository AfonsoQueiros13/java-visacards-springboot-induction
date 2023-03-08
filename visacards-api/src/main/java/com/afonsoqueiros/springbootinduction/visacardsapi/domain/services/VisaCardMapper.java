package com.afonsoqueiros.springbootinduction.visacardsapi.domain.services;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.GetVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.UpdateVisaCard;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface VisaCardMapper {
    VisaCardMapper INSTANCE = Mappers.getMapper( VisaCardMapper.class );

    GetVisaCard mapVisaCardToGetVisaCard(Optional<VisaCard> visaCard);
    VisaCard mapCreateVisaCardToVisaCard(Optional<CreateVisaCard> visaCard);
    VisaCard mapUpdateVisaCardToVisaCard(UpdateVisaCard updateVisaCard);
}
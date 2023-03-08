package com.afonsoqueiros.springbootinduction.visacardsapi.controllers;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.domain.services.VisaCardService;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreditCardCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VisaCardsController extends HomeController {
    @Autowired
    private VisaCardService visaCardService;

    @GetMapping(value = "/{id}")
    public Optional<VisaCard> getVisaCardInfo(@PathVariable(value = "id") long id){
        return this.visaCardService.findById(id);
    }

    @PostMapping()
    public String createVisaCard(@RequestBody CreditCardCreateDto creditCardCreateDto){
        return "createVisaCard";
    }

    @PutMapping(value = "/{id}")
    public String updateVisaCard(@PathVariable(value = "id") long id){
        return "updateVisaCard";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteVisaCard(@PathVariable(value = "id") long id){
        return "deleteVisaCard";
    }

}

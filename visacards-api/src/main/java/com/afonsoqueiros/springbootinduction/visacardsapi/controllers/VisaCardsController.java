package com.afonsoqueiros.springbootinduction.visacardsapi.controllers;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.services.VisaCardService;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.GetVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.UpdateVisaCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VisaCardsController extends HomeController {
    @Autowired
    private VisaCardService visaCardService;

    @GetMapping(value = "{id}")
    public Optional<GetVisaCard> getVisaCardInfo(@PathVariable(value = "id") long id){
        return Optional.ofNullable(this.visaCardService.findById(id));
    }

    @PostMapping()
    public Optional<Boolean> createVisaCard(@RequestBody CreateVisaCard createVisaCard){

        return Optional.of(this.visaCardService.createVisaCard(createVisaCard));
    }

    @PutMapping(value = "{id}")
    public Optional<Boolean> updateVisaCard(@PathVariable(value = "id") long id, @RequestBody UpdateVisaCard updateVisaCard){

        return Optional.of(this.visaCardService.updateVisaCard(updateVisaCard, id));
    }

    @DeleteMapping(value = "{id}")
    public Optional<Boolean> deleteVisaCard(@PathVariable(value = "id") long id){

        return Optional.of(this.visaCardService.deleteVisaCard(id));
    }

}

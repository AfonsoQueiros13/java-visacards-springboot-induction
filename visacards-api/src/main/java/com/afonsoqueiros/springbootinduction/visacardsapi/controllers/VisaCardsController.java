package com.afonsoqueiros.springbootinduction.visacardsapi.controllers;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.services.VisaCardService;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.GetVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.UpdateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.exceptions.GlobalExceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VisaCardsController extends HomeController {
    @Autowired
    private VisaCardService visaCardService;

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<GetVisaCard> getVisaCardInfo(@PathVariable(value = "id") long id){
        GetVisaCard getVisaCard = this.visaCardService.findById(id);
        if(getVisaCard != null)
            return Optional.of(getVisaCard);
        else {
            throw new GlobalExceptions.ResourceNotFoundException();
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public GetVisaCard createVisaCard(@RequestBody CreateVisaCard createVisaCard){

        Long id = this.visaCardService.createVisaCard(createVisaCard);
        return this.visaCardService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "{id}")
    public void updateVisaCard(@PathVariable(value = "id") long id, @RequestBody UpdateVisaCard updateVisaCard){

        this.visaCardService.updateVisaCard(updateVisaCard, id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public void deleteVisaCard(@PathVariable(value = "id") long id){

        this.visaCardService.deleteVisaCard(id);
    }

}

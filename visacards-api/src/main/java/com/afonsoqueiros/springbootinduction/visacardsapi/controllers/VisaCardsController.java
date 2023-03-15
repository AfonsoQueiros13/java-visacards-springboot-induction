package com.afonsoqueiros.springbootinduction.visacardsapi.controllers;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.domain.services.VisaCardService;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.GetVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.UpdateVisaCard;

import com.afonsoqueiros.springbootinduction.visacardsapi.exceptions.ResourceAlreadyAddedException;
import com.afonsoqueiros.springbootinduction.visacardsapi.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VisaCardsController extends HomeController {
    @Autowired
    private VisaCardService visaCardService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}")
    public GetVisaCard getVisaCardInfo(@PathVariable(value = "id") long id) throws ResourceNotFoundException {

        return this.visaCardService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public GetVisaCard createVisaCard(@RequestBody CreateVisaCard createVisaCard) throws ResourceAlreadyAddedException {

        return visaCardService.createVisaCard(createVisaCard);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "{id}")
    public void updateVisaCard(@PathVariable(value = "id") long id, @RequestBody UpdateVisaCard updateVisaCard) throws ResourceNotFoundException {

        this.visaCardService.updateVisaCard(updateVisaCard, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public void deleteVisaCard(@PathVariable(value = "id") long id) throws ResourceNotFoundException {

        this.visaCardService.deleteVisaCard(id);
    }

}

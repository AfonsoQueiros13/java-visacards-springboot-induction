package com.afonsoqueiros.springbootinduction.visacardsapi.api;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.domain.services.VisaCardService;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreditCardCreateDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
public class VisaCardsController extends HomeController {
    @Autowired
    private VisaCardService visaCardService;

    @Autowired
    public VisaCardsController(VisaCardService visaCardService) {

        this.visaCardService = visaCardService;
    }

    @GetMapping(value = "/{id}")
    public VisaCard getVisaCardInfo(@PathVariable(value = "id") long id){

        return this.visaCardService.fingById(id);

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

package com.afonsoqueiros.springbootinduction.visacardsapi.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/learning/visa/electron/")
public class VisaCardsController {

    @GetMapping(value = "")
    public String getVisaCardInfo(){
        return "getVisaInfo";
    }
    @PostMapping(value = "")
    public String createVisaCard(){
        return "createVisaCard";
    }
    @PutMapping(value = "")
    public String updateVisaCard(){
        return "updateVisaCard";
    }
    @DeleteMapping(value = "")
    public String deleteVisaCard(){
        return "deleteVisaCard";
    }

}

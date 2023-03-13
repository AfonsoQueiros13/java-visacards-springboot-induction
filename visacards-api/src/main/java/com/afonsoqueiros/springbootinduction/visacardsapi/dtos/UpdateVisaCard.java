package com.afonsoqueiros.springbootinduction.visacardsapi.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateVisaCard {
    public String address;
    public String lastName;
    public String phoneNumber;

}

package com.afonsoqueiros.springbootinduction.visacardsapi.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CreateVisaCard {
    public String address;
    public String cardNumber;
    public String cvv;
    public String expireDate;
    public String firstName;
    public String lastName;
    public String phoneNumber;

}

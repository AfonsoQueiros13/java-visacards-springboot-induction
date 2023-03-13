package com.afonsoqueiros.springbootinduction.visacardsapi.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetVisaCard {
    public String address;
    public String cardNumber;
    public String createdDate;
    public String expireDate;
    public String firstName;
    public long id;
    public String lastName;
    public String phoneNumber;
    public String updatedDate;

}

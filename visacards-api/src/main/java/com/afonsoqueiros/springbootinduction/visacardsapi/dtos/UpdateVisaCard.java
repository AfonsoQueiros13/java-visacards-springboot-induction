package com.afonsoqueiros.springbootinduction.visacardsapi.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateVisaCard {
    public String address;
    @Size(max = 16)
    public String lastName;
    @Size(max = 64)
    public String phoneNumber;

}

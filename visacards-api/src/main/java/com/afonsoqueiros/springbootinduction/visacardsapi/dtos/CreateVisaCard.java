package com.afonsoqueiros.springbootinduction.visacardsapi.dtos;

import com.afonsoqueiros.springbootinduction.visacardsapi.utils.annotations.VisaCardNumber;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CreateVisaCard {
    public String address;

    @VisaCardNumber
    @NotBlank(message = "Card number cannot be empty")
    @Column(unique=true)
    public String cardNumber;

    @NotNull
    @Size(max = 3)
    public String cvv;

    @NotNull
    public String expireDate;

    @NotNull
    @Size(max = 16)
    public String firstName;

    @NotNull
    @Size(max = 16)
    public String lastName;

    @Size(max = 64)
    public String phoneNumber;

}

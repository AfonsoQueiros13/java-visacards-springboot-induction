package com.afonsoqueiros.springbootinduction.visacardsapi.domain;

import com.afonsoqueiros.springbootinduction.visacardsapi.utils.serialization.DateDeSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VisaCard {
    public String address;

    @NotBlank(message = "Card number cannot be empty")
    @Column(unique=true)
    public String cardNumber;

    @NotNull
    @Size(max = 3)
    public String cvv;

    public LocalDateTime createdDate;

    @NotNull
    public String expireDate;

    @NotNull
    @Size(max = 16)
    public String firstName;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;

    @NotNull
    @Size(max = 16)
    public String lastName;
    @Size(max = 64)
    public String phoneNumber;
    public LocalDateTime  updateDate;

}

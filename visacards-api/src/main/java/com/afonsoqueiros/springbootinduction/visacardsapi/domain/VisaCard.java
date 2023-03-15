package com.afonsoqueiros.springbootinduction.visacardsapi.domain;

import com.afonsoqueiros.springbootinduction.visacardsapi.utils.annotations.VisaCardNumber;
import com.fasterxml.jackson.annotation.JsonFormat;

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

    @VisaCardNumber
    @NotBlank(message = "Card number cannot be empty")
    @Column(unique=true)
    public String cardNumber;

    @NotNull
    @Size(max = 3)
    public String cvv;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    public LocalDateTime  updateDate;

}

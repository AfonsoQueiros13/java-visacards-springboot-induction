package com.afonsoqueiros.springbootinduction.visacardsapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class VisaCard {
    public String address;
    @NotBlank(message = "Card number cannot be empty")
    public String cardNumber;
    @NotNull
    public String cvv;
    public LocalDateTime createdDate;
    @NotNull
    public String expireDate;
    @NotNull
    public String firstName;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;
    @NotNull
    public String lastName;
    public String phoneNumber;
    public LocalDateTime  updateDate;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDateTime  getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime  createdDate) {
        this.createdDate = createdDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdatedDate(LocalDateTime  updatedDate) {
        this.updateDate = updatedDate;
    }

}

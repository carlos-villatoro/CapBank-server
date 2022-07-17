package com.capbank.CapBank.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "account")
public class Account {
    @Id
    private long id;
    private String accountNumber;
    private String accountType;
    private Double openingBalance;
    private LocalDate openingDate;



    public Account() {
        super();
//        TODO auto generated constructor stub
    }

    public Account(String accountNumber, String accountType, Double openingBalance, LocalDate openingDate) {
        super();
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.openingBalance = openingBalance;
        this.openingDate = openingDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }
}

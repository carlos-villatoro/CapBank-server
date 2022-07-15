package com.capbank.CapBank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    // private Account account;
    
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        // this.account = account;
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.otherClasses;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Polly
 */
@Getter
@Setter
public class LoginRequest {
    private String login;
    private String password;
    
    public LoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

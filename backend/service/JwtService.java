/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.service;

import com.example.backend.jwt.JwtUtils;
import com.example.backend.model.User;
import com.example.backend.otherClasses.JwtResponse;
import com.example.backend.otherClasses.LoginRequest;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/**
 *
 * @author Polly
 */
@Service
public class JwtService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByLogin(loginRequest.getLogin());
        if (user == null || !encoder.matches(loginRequest.getPassword(), user.getPassword())){
            return ResponseEntity.badRequest().body("Неверно введенный логин и/или пароль");
        }
        String token = jwtUtils.generateJwtToken(user);
        return ResponseEntity.ok(
                new JwtResponse(
                        user.getId(),
                        token,
                        user.getLogin()
                )
        );
//        String name = jwtUtils.getNameFromJwtToken(token);
    }

}

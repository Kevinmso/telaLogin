package com.estudo.TelaLogin.controller;

import com.estudo.TelaLogin.model.User;
import com.estudo.TelaLogin.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return ResponseEntity.ok(authService.login(user));
    }

    @PostMapping('/register')
    public ResponseEntity<String> register(@RequestBody User user){
        return ResponseEntity.ok(authService.register(user));
    }
}
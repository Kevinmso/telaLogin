package com.estudo.TelaLogin.service;

import com.estudo.TelaLogin.model.User;
import com.estudo.TelaLogin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser.isPresent()) {
            return "Nome de usuário já está em uso.";
        }

        userRepository.save(user);
        return "Usuário registrado com sucesso!";
    }

    public String login(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            return "Login bem-sucedido!";
        }

        return "Usuário ou senha inválidos.";
    }
}
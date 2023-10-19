package ru.niseco.helpfullservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.niseco.helpfullservice.dtos.JwtRequest;
import ru.niseco.helpfullservice.services.serviceIMPL.AuthenticationServiceImpl;

@RestController
@RequiredArgsConstructor
public class AuthController{
    private final AuthenticationServiceImpl authenticationService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authenticationService.authenticateUser(authRequest);
    }

    @GetMapping("/secured")
    public String helloSecurity() {
        return "Hello";
    }
}

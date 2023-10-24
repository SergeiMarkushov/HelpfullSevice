package ru.niseco.helpfullservice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.niseco.helpfullservice.dtos.JwtRequest;

@Component
public interface AuthenticationService {

    public ResponseEntity<?> authenticateUser(JwtRequest authRequest);
}

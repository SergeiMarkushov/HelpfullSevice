package ru.niseco.helpfullservice.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.niseco.helpfullservice.entities.User;

import java.util.Optional;

@Service
public interface UserService extends UserDetailsService {

    public Optional<User> findByUsername(String username);
}

package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean setAddress(String address, String email) {
        log.info(email);
        userRepository.updateAddress(address,email);
        return true;
    }

    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public String getAddress(String email) {
        log.info(email);
        return userRepository.getEmail(email);
    }
}

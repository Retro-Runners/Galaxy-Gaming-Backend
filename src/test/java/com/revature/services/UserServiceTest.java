package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Column;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private User newUser;
    private User dbUser;
    private String email ="testuser@gmail.com";

    @BeforeEach
    public void populateObjects(){


        newUser = new User();
        newUser.setId(1);
        newUser.setEmail(email);
        newUser.setPassword("password");
        newUser.setFirstName("Test");
        newUser.setLastName("User");
        newUser.setAddress("");


        dbUser = new User();
        dbUser.setId(1);
        dbUser.setEmail(email);
        dbUser.setPassword("encryptedPassword");
        dbUser.setLastName("User");
        dbUser.setAddress("");
    }
    @Test
    void givenNewUser_createUser_returnsCreatedEntity() {
        // define your stubbing behavior

        //Mockito.when(passwordEncoder.encode("testPassword")).thenReturn("encryptedPassword");
        Mockito.when(userRepository.save(newUser)).thenReturn(dbUser);

        // provide your given arguments -> taken care of in BeforeEach
        // call your method to be tested

        User user = userService.save(newUser);

        // make some assertions
        Assertions.assertEquals(dbUser.getId(), user.getId());

    }

    @Test
    void save() {
    }
}
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private User newUser;
    private User dataDBUser;

    private int id = 1;
    private String email = "testuser@gmail.com";
    private String password = "password";
    private String firstName = "Test";
    private String lastName = "User";
    private String address = "123 Lake St.";

    @BeforeEach
    public void populateObjects(){


        newUser = new User();
        newUser.setId(1);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setAddress(address);


        dataDBUser = new User();
        dataDBUser.setId(1);
        dataDBUser.setEmail(email);
        dataDBUser.setPassword(password);
        dataDBUser.setFirstName(firstName);
        dataDBUser.setLastName(lastName);
        dataDBUser.setAddress(address);

    }
    @Test
    void givenNewUser_createUser_returnsCreatedEntity() {
        // define your stubbing behavior

        //Mockito.when(passwordEncoder.encode("testPassword")).thenReturn("encryptedPassword");
        Mockito.when(userRepository.save(newUser)).thenReturn(dataDBUser);

        // provide your given arguments -> taken care of in BeforeEach
        // call your method to be tested

        User user = userService.save(newUser);

        // make some assertions
        Assertions.assertEquals(dataDBUser.getId(), user.getId());

    }

    @Test
    public void NewUser_CreatesDBUser(){

        Mockito.when(userRepository.save(newUser)).thenReturn(dataDBUser);

        User finalUser = userService.save(newUser);

        Assertions.assertEquals(dataDBUser.getId(), finalUser.getId());
        Assertions.assertEquals(dataDBUser.getEmail(), finalUser.getEmail());
        Assertions.assertEquals(dataDBUser.getPassword(), finalUser.getPassword());
        Assertions.assertEquals(dataDBUser.getFirstName(), finalUser.getFirstName());
        Assertions.assertEquals(dataDBUser.getLastName(), finalUser.getLastName());
        Assertions.assertEquals(dataDBUser.getAddress(), finalUser.getAddress());

    }

    @Test
    public void Id_ReturnsUserwithId() {
        Mockito.when(userRepository.findById(id)).thenReturn(dataDBUser);

        User finalUser = userService.findById(id);

        Assertions.assertEquals(dataDBUser.getId(), finalUser.getId());
        Assertions.assertEquals(dataDBUser.getEmail(), finalUser.getEmail());
        Assertions.assertEquals(dataDBUser.getPassword(), finalUser.getPassword());
        Assertions.assertEquals(dataDBUser.getFirstName(), finalUser.getFirstName());
        Assertions.assertEquals(dataDBUser.getLastName(), finalUser.getLastName());
        Assertions.assertEquals(dataDBUser.getAddress(), finalUser.getAddress());
    }

    @Test
    public void Email_ReturnsUserwithEmail() {
        Mockito.when(userRepository.findByEmail(email)).thenReturn(dataDBUser);

        User finalUser = userService.findByEmail(email);

        Assertions.assertEquals(dataDBUser.getId(), finalUser.getId());
        Assertions.assertEquals(dataDBUser.getEmail(), finalUser.getEmail());
        Assertions.assertEquals(dataDBUser.getPassword(), finalUser.getPassword());
        Assertions.assertEquals(dataDBUser.getFirstName(), finalUser.getFirstName());
        Assertions.assertEquals(dataDBUser.getLastName(), finalUser.getLastName());
        Assertions.assertEquals(dataDBUser.getAddress(), finalUser.getAddress());

    }
}
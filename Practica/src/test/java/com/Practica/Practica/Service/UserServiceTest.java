package com.Practica.Practica.Service;

import com.Practica.Practica.Model.User;
import com.Practica.Practica.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    void shouldSaveUser() {
        User user = new User(null,"Braian","1234");
        User savedUser= new User(1L,"Braian","1234");

        when(userRepository.save(user)).thenReturn(savedUser);

        User result = userService.saveUser(user);

        assertNotNull(result);
        assertEquals(1L,result.getId());
        assertEquals("Braian",result.getName());
        assertEquals("1234",result.getPassword());
        verify(userRepository).save(user);

    }

    @Test
    void shouldGetAllUsers() {
        List<User> users = List.of(
                new User(1L,"Braian","1234"),
                new User(2L,"Victoria","1234")
        );

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2,result.size());
        assertEquals("Victoria",result.get(1).getName());
        verify(userRepository).findAll();


    }

    @Test
    void shouldGetUserById() {
    }

    @Test
    void shouldDeleteUser() {
    }
}
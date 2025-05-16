package com.Practica.Practica.Service;

import com.Practica.Practica.Model.User;
import com.Practica.Practica.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

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
        Long id = 1l;
        User user = new User(id,"Braian","1234");

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        Optional<User> result = userService.getUserById(id);

        assertTrue(result.isPresent());
        assertEquals(1l,result.get().getId());
        assertEquals("Braian",result.get().getName());
        assertEquals("1234",result.get().getPassword());
        verify(userRepository).findById(id);

    }

    @Test
    void shouldDeleteUser() {
        User user= new User(1L,"Braian","1234");

        userService.deleteUser(user);

        verify(userRepository).delete(user);
    }
}
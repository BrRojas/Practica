package com.Practica.Practica.service;

import com.Practica.Practica.dto.UserDTO;
import com.Practica.Practica.exception.UserNotFoundException;
import com.Practica.Practica.model.User;
import com.Practica.Practica.repository.UserRepository;
import com.Practica.Practica.util.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;


    @Test
    void shouldSaveUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Braian");
        userDTO.setPassword("1234");

        User user = UserMapper.toEntity(userDTO);

        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO result = userServiceImpl.saveUser(userDTO);

        assertNotNull(result);
        assertEquals("Braian",result.getName());
        assertEquals("1234",result.getPassword());
        verify(userRepository).save(any(User.class));

    }

    @Test
    void shouldGetAllUsers() {
        User user = new User(1L, "Braian", "1234");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        UserDTO result = userServiceImpl.getUserById(1L);

        assertNotNull(result);
        assertEquals("Braian", result.getName());
        verify(userRepository).findById(1L);


    }

    @Test
    void shouldGetUserById() {
        Long id = 1l;
        User user = new User(id,"Braian","1234");

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        UserDTO result = userServiceImpl.getUserById(id);

        assertEquals("Braian",result.getName());
        assertEquals("1234",result.getPassword());
        verify(userRepository).findById(id);

    }

    @Test
    void shouldThrowWhenUserNotFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> {
            userServiceImpl.getUserById(99L);
        });
    }


    //--------------recomendacion IA--------------
    @Test
    void shouldDeleteUser() {
        // Arrange
        UserDTO dto = new UserDTO();
        dto.setName("Braian");
        dto.setPassword("1234");

        doNothing().when(userRepository).delete(any(User.class));

        // Act
        userServiceImpl.deleteUserDTO(dto);

        // Assert
        verify(userRepository).delete(any(User.class));
    }
}
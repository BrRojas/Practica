package com.Practica.Practica.service;

import com.Practica.Practica.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    void deleteUserDTO(UserDTO userDTO);

}

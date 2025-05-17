package com.Practica.Practica.service;

import com.Practica.Practica.dto.UserDTO;
import com.Practica.Practica.exception.UserNotFoundException;
import com.Practica.Practica.model.User;
import com.Practica.Practica.repository.UserRepository;
import com.Practica.Practica.util.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO){
        User user = UserMapper.toEntity(userDTO);
        User saved = userRepository.save(user);
        return UserMapper.toDTO(saved);
    };


    @Override
    public List<UserDTO> getAllUsers(){
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con ID " + id));
        return UserMapper.toDTO(user);
        }

    @Override
    public void deleteUserDTO(UserDTO userDTO){
        User user = UserMapper.toEntity(userDTO);
        userRepository.delete(user);
        }



}

package com.Practica.Practica.service;

import com.Practica.Practica.exception.UserNotFoundException;
import com.Practica.Practica.model.User;
import com.Practica.Practica.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    };


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con ID " + id));
    };



    public void deleteUser(User user){
        userRepository.delete(user);
    }



}

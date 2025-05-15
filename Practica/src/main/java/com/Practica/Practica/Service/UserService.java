package com.Practica.Practica.Service;

import com.Practica.Practica.Model.User;
import com.Practica.Practica.Repository.UserRepository;

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


    public Optional<User> getUserById(Long id){
      return userRepository.findById(id);
    };

    





}

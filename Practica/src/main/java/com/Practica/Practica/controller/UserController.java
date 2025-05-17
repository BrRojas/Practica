package com.Practica.Practica.controller;

import com.Practica.Practica.dto.UserDTO;
import com.Practica.Practica.model.User;
import com.Practica.Practica.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PatchMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO dto){
        return ResponseEntity.ok(userService.saveUser(dto));
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }



}

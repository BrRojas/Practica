package com.Practica.Practica.util;

import com.Practica.Practica.dto.UserDTO;
import com.Practica.Practica.model.User;

public class UserMapper {
    // Convierte de DTO a entidad
    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        return user;
    }

    // Convierte de entidad a DTO
    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());
        return dto;
    }
}

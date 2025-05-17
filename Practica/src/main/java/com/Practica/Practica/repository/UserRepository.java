package com.Practica.Practica.repository;

import com.Practica.Practica.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

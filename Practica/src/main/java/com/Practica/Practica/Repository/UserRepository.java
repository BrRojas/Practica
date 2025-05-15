package com.Practica.Practica.Repository;

import com.Practica.Practica.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

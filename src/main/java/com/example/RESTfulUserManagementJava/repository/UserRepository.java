package com.example.RESTfulUserManagementJava.repository;

import com.example.RESTfulUserManagementJava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}

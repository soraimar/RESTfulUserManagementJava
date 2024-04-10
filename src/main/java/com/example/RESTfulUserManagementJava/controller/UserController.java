package com.example.RESTfulUserManagementJava.controller;

import com.example.RESTfulUserManagementJava.dto.UserDTO;
import com.example.RESTfulUserManagementJava.dto.UserResponseDTO;
import com.example.RESTfulUserManagementJava.entity.User;
import com.example.RESTfulUserManagementJava.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        UserResponseDTO userResponseDTO = convertToResponseDTO(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    private UserResponseDTO convertToResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setCreatedDate(user.getCreatedDate());
        dto.setUpdatedDate(user.getUpdatedDate());
        dto.setLastLoginDate(user.getLastLoginDate());
        dto.setToken(user.getToken());
        dto.setActive(user.isActive());

        return dto;
    }
}

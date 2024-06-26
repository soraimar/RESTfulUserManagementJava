package com.example.RESTfulUserManagementJava.service;

import com.example.RESTfulUserManagementJava.dto.PhoneDTO;
import com.example.RESTfulUserManagementJava.dto.UserDTO;
import com.example.RESTfulUserManagementJava.dto.UserUpdateDTO;
import com.example.RESTfulUserManagementJava.entity.Phone;
import com.example.RESTfulUserManagementJava.entity.User;
import com.example.RESTfulUserManagementJava.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(UserDTO userDTO) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setPhones(convertPhoneDTOsToPhones(new HashSet<>(userDTO.getPhones())));
        user.setToken(JwtService.createJWTToken(userDTO.getEmail(), userDTO.getName()));
        //TODO: preguntar si se debe validar el token al crear el usuario o solo al hacer login
        user.setActive(JwtService.validateJWTToken(user.getToken()));
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(UUID userId, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado con ID: " + userId));

        if (userUpdateDTO.getName() != null && !userUpdateDTO.getName().isEmpty()){
            user.setName(userUpdateDTO.getName());
        }
        if (userUpdateDTO.getPhones() != null && !userUpdateDTO.getPhones().isEmpty()){
            user.setPhones(convertPhoneDTOsToPhones(userUpdateDTO.getPhones()));
        }
        return userRepository.save(user);
    }

    @Transactional
    public User getUser(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado con ID: " + userId));
    }

    private Set<Phone> convertPhoneDTOsToPhones(Set<PhoneDTO> phoneDTOs) {
        return phoneDTOs.stream().map(this::convertToPhoneEntity).collect(Collectors.toSet());
    }

    private Phone convertToPhoneEntity(PhoneDTO phoneDTO) {
        Phone phone = new Phone();
        phone.setNumber(phoneDTO.getNumber());
        phone.setCitycode(phoneDTO.getCitycode());
        phone.setCountrycode(phoneDTO.getCountrycode());
        return phone;
    }
}
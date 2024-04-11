package com.example.RESTfulUserManagementJava.service;

import com.example.RESTfulUserManagementJava.dto.PhoneDTO;
import com.example.RESTfulUserManagementJava.dto.UserDTO;
import com.example.RESTfulUserManagementJava.entity.Phone;
import com.example.RESTfulUserManagementJava.entity.User;
import com.example.RESTfulUserManagementJava.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
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
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        //user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setPassword(userDTO.getPassword());
        user.setPhones(convertPhoneDTOsToPhones(new HashSet<>(userDTO.getPhones())));
        return userRepository.save(user);
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



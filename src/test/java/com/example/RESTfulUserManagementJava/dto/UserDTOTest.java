package com.example.RESTfulUserManagementJava.dto;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class UserDTOTest {

    private LocalValidatorFactoryBean validator;

    @BeforeEach
    void setUp() {
        validator = new LocalValidatorFactoryBean();
        validator.afterPropertiesSet();
    }

    @Test
    void whenEmailAndPasswordIsValid_thenNoConstraintViolations() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Example");
        userDTO.setEmail("example@domain.cl");
        userDTO.setPassword("Password1");
        userDTO.setPhones(null);

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);

        assertThat(violations).isEmpty();
    }

    @Test
    void whenEmailIsInvalid_thenConstraintViolationsExist() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Example");
        userDTO.setEmail("example@domain.com");
        userDTO.setPassword("Password1");
        userDTO.setPhones(null);

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        String expectedMessage = "El correo electrónico debe estar en el formato aaaaaaa@dominio.cl";
        boolean hasNameRequiredViolation = violations.stream()
                .anyMatch(violation -> expectedMessage.equals(violation.getMessage()));

        assertThat(violations).isNotEmpty();
        assertThat(hasNameRequiredViolation).isTrue();
    }

    @Test
    void whenPasswordIsInvalid_thenConstraintViolationsExist() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Example");
        userDTO.setEmail("example@domain.com");
        userDTO.setPassword("claveInvalida");
        userDTO.setPhones(null);

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        String expectedMessage = "La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número";
        boolean hasNameRequiredViolation = violations.stream()
                .anyMatch(violation -> expectedMessage.equals(violation.getMessage()));

        assertThat(violations).isNotEmpty();
        assertThat(hasNameRequiredViolation).isTrue();
    }

    @Test
    void whenNameIsInvalid_thenConstraintViolationsExist() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("");
        userDTO.setEmail("example@domain.com");
        userDTO.setPassword("claveInvalida");
        userDTO.setPhones(null);

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        String expectedMessage = "El nombre es obligatorio";
        boolean hasNameRequiredViolation = violations.stream()
                .anyMatch(violation -> expectedMessage.equals(violation.getMessage()));

        assertThat(violations).isNotEmpty();
        assertThat(hasNameRequiredViolation).isTrue();

    }
}

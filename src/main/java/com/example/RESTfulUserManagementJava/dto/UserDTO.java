package com.example.RESTfulUserManagementJava.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class UserDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 50)
    @Schema(description = "Full name of the user", example = "Juan Perez", required = true)
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z]+\\.cl$", message = "El correo electrónico debe estar en el " +
            "formato aaaaaaa@dominio.cl")
    @Schema(description = "Email address of the user, must follow the format aaaaaaa@dominio.cl", example = "usuario@dominio.cl")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",
            message = "La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número")
    @Schema(description = "Password of the user, must be at least 8 characters long and include a mix of " +
            "upper and lower case letters and numbers", example = "Password1", required = true)
    private String password;

    @Schema(description = "List of phone numbers associated with the user")
    private List<PhoneDTO> phones;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }
}

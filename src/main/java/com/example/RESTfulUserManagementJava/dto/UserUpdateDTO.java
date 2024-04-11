package com.example.RESTfulUserManagementJava.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

@Schema(description = "Data Transfer Object for updating user information including name and phones")
public class UserUpdateDTO {
    @Schema(description = "Name of the user", example = "John Doe")
    private String name;

    @Schema(description = "Set of phone details associated with the user")
    private Set<PhoneDTO> phones;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneDTO> phones) {
        this.phones = phones;
    }
}

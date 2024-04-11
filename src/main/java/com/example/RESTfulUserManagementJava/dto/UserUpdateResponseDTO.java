package com.example.RESTfulUserManagementJava.dto;

import com.example.RESTfulUserManagementJava.entity.Phone;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

@Schema(description = "Response DTO for user update operation, extending the base user response with additional fields.")
public class UserUpdateResponseDTO extends UserResponseDTO {

    @Schema(description = "Updated name of the user", example = "Jane Doe")
    private String name;

    @Schema(description = "Indicates whether the user is active after the update", example = "true")
    private boolean active;

    @Schema(description = "Set of phone details associated with the user after the update")
    private Set<Phone> phones;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}

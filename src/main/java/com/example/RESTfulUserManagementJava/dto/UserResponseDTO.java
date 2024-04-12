package com.example.RESTfulUserManagementJava.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.UUID;

public class UserResponseDTO {
    @Schema(description = "ID of the user", example = "1")
    private UUID id;

    @Schema(description = "Date when the user was created", example = "2023-04-12T10:00:00Z", format = "date-time")
    private Date createdDate;

    @Schema(description = "Date when the user was last updated", example = "2023-04-12T12:00:00Z", format = "date-time")
    private Date updatedDate;

    @Schema(description = "Date of the user's last login", example = "2023-04-12T11:00:00Z", format = "date-time")
    private Date lastLoginDate;

    @Schema(description = "token", example = "2023-04-12T11:00:00Z")
    private String token;

    @Schema(description = "Indicates whether the user is active or not", example = "true")
    private boolean active;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

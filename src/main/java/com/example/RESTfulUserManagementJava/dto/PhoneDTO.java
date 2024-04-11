package com.example.RESTfulUserManagementJava.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class PhoneDTO {
    @Schema(description = "The phone number", example = "1234567890")
    private String number;

    @Schema(description = "The city code of the phone number", example = "1")
    private String citycode;

    @Schema(description = "The city code of the phone number", example = "1")
    private String countrycode;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
}

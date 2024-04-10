package com.example.RESTfulUserManagementJava.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Phone {
    private String number;
    private String citycode;
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


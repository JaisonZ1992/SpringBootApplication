package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class AddressDto implements Serializable {

    private Long id;
    @NotBlank(message = "Street is mandatory")
    private String street;
    @NotBlank(message = "District is mandatory")
    private String district;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}

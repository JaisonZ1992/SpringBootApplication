package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDetailDto implements Serializable {

    private int id;
    @NotBlank(message = "Person name is mandatory")
    private String name;
    @Valid
    @NotNull
    private AddressDto address;
    private Set<@Valid OrderDto> orders;
    private Set<@Valid GroupDto> associatedGroups;

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public Set<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderDto> orders) {
        this.orders = orders;
    }

    public Set<GroupDto> getAssociatedGroups() {
        return associatedGroups;
    }

    public void setAssociatedGroups(Set<GroupDto> associatedGroups) {
        this.associatedGroups = associatedGroups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

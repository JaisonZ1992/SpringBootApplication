package com.example.demo.dto;

import java.io.Serializable;
import java.util.Set;

public class PersonDetailDto implements Serializable {

    private int id;
    private String name;
    private AddressDto address;
    private Set<OrderDto> orders;
    private Set<GroupDto> associatedGroups;

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

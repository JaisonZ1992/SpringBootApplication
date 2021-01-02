package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "district")
    private String district;

    @OneToOne(mappedBy = "address")
    private Person person;

    public Address(){
    }

    public Address(String street, String district) {
        this.street = street;
        this.district = district;
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

    public Long getId() {
        return id;
    }
}

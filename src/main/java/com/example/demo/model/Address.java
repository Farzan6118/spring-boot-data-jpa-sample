package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "addresses")
public class Address extends GeneralInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String mainStreetName;
    private String streetName;
    private String blockNumber;
    private String country;
    private String countryCode;
    private String city;
    private String cityCode;
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
}

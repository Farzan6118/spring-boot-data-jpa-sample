package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
public class Department extends GeneralInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    private String depName;
    private String depFloor;
    private String depCode;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<User> users;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}

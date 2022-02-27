package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
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

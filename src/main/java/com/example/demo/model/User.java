package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends GeneralInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDateTime birthDate;
    private String nationalNumber;
//    @OneToMany(mappedBy = "user")
//    @Column(name = "contact_address")
//    private Set<Contact> contacts;
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;
//    @ManyToOne
//    @JoinColumn(name = "department_id")
//    private Department department;

}
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
@Table(name = "roles")
public class Role extends GeneralInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    private String name;
    private String levelNumber;
    @OneToMany(mappedBy = "role")
    private Set<User> users;
    private String permissionString;
}

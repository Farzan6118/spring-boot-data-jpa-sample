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

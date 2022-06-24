package com.code.JavaProject.Entity;


import com.code.JavaProject.Model.role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class account {
    @Id
    @Column(
            name = "id"
            , nullable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(
            name = "username",
            nullable = false,
            unique = true
    )
    private String username;
    @Column(
            name = "password",
            nullable = false
    )
    private String password;
    private String fullName ;
    @Column(
            unique = true
    )
    private String email;
    private String address;
    private String phone ;
    private role userRole;
    private boolean enable ;
}

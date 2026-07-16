package org.markandey.springsecuritydemo.Model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @Column(unique=true, nullable=false)
    private String email;
    private String name;
    private String password;
//    private String role;
}

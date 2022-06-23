package com.makeev.mvchibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@NoArgsConstructor
@Getter @Setter
@ToString

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotBlank(message = "enter name")
    @Size(min=4, max=30, message = "min4max30")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "enter lastname")
    @Size(min=4, max=30, message = "min4max30")
    private String lastName;

    @Column(name="age")
    @Min(value=0, message=">0")
    @Max(value = 150, message = "<150")
    private int age;

    @Column(name = "email")
    @NotBlank(message = "enter email")
    @Email(message = "not valid email")
    private String email;
}

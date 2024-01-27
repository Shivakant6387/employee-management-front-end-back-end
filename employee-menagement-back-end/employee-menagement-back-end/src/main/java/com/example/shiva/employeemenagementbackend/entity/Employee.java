package com.example.shiva.employeemenagementbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "First Name cannot be blank")
    @Column(name = "first_name")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    @Column(name = "last_name")
    private String lastName;
    @Email
    @Column(name = "email_id",unique = true)
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}

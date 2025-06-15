package com.example.springbootcourseregistrationapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String matricNo;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Registration> registrations = new ArrayList<>();
}

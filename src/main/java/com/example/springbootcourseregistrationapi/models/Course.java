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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    @Column(unique = true)
    private String title;

    private int unit;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Registration> registrations = new ArrayList<>();
}

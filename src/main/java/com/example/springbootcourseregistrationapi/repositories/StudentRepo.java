package com.example.springbootcourseregistrationapi.repositories;

import com.example.springbootcourseregistrationapi.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findByMatricNo(String studentMatriculationNumber);
}

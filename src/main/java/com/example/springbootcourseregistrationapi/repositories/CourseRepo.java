package com.example.springbootcourseregistrationapi.repositories;

import com.example.springbootcourseregistrationapi.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {
    Optional<Course> findByCode(String code);

    Optional<Course> findByTitle(String title);
}

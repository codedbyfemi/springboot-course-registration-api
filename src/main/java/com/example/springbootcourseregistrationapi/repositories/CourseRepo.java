package com.example.springbootcourseregistrationapi.repositories;

import com.example.springbootcourseregistrationapi.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}

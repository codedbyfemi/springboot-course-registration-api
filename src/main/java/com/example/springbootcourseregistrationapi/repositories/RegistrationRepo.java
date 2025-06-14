package com.example.springbootcourseregistrationapi.repositories;

import com.example.springbootcourseregistrationapi.models.Course;
import com.example.springbootcourseregistrationapi.models.Registration;
import com.example.springbootcourseregistrationapi.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepo extends JpaRepository<Registration, Long> {
    Optional<Registration> findByStudentAndCourse(Student student, Course course);

    List<Registration> findByStudent(Student student);

    List<Registration> findByCourse(Course course);
}

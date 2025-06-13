package com.example.springbootcourseregistrationapi.repositories;

import com.example.springbootcourseregistrationapi.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepo extends JpaRepository<Registration, Long> {
}

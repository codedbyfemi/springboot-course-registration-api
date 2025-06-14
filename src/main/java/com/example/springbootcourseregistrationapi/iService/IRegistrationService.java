package com.example.springbootcourseregistrationapi.iService;

import com.example.springbootcourseregistrationapi.dto.CourseDTO;
import com.example.springbootcourseregistrationapi.dto.RegistrationDTO;
import com.example.springbootcourseregistrationapi.dto.StudentDTO;

import java.util.List;

public interface IRegistrationService {
    RegistrationDTO registerStudentToCourse(Long studentId, Long courseId);
    List<RegistrationDTO> getAllRegistrations();
    List<CourseDTO> getCoursesByStudentId(Long studentId);
    List<StudentDTO> getStudentsByCourseId(Long courseId);
}

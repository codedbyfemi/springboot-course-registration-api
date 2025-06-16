package com.example.springbootcourseregistrationapi.iService;

import com.example.springbootcourseregistrationapi.dto.CourseDTO;
import com.example.springbootcourseregistrationapi.dto.RegistrationDTO;
import com.example.springbootcourseregistrationapi.dto.StudentDTO;

import java.util.List;

public interface IRegistrationService {
    RegistrationDTO registerStudentToCourse(String studentMatriculationNumber, String courseCode);
    List<RegistrationDTO> getAllRegistrations();
    List<CourseDTO> getCoursesByStudentMatriculationNumber(String studentMatriculationNumber);
    List<StudentDTO> getStudentsByCourseCode(String courseCode);

    void unRegisterStudentFromCourse(String studentMatriculationNumber, String courseCode);
}

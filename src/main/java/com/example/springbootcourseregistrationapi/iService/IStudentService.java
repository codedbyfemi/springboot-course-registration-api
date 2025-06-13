package com.example.springbootcourseregistrationapi.iService;

import com.example.springbootcourseregistrationapi.dto.StudentDTO;
import com.example.springbootcourseregistrationapi.models.Student;

import java.util.List;

public interface IStudentService {

    Student createStudent(StudentDTO student);
   List<StudentDTO> getAllStudents();
}

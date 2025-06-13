package com.example.springbootcourseregistrationapi.controllers;

import com.example.springbootcourseregistrationapi.dto.StudentDTO;
import com.example.springbootcourseregistrationapi.iService.IStudentService;
import com.example.springbootcourseregistrationapi.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentDTO student) {
       Student savedStudent = studentService.createStudent(student);
       return ResponseEntity.ok().body(savedStudent);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> studentDTOList = studentService.getAllStudents();
        return ResponseEntity.ok(studentDTOList);
    }
}

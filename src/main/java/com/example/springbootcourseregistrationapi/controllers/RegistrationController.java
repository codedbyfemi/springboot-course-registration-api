package com.example.springbootcourseregistrationapi.controllers;

import com.example.springbootcourseregistrationapi.dto.CourseDTO;
import com.example.springbootcourseregistrationapi.dto.RegistrationDTO;
import com.example.springbootcourseregistrationapi.dto.StudentDTO;
import com.example.springbootcourseregistrationapi.iService.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private IRegistrationService registrationService;

    @PostMapping
    public ResponseEntity<RegistrationDTO> register(@RequestParam Long studentId, @RequestParam Long courseId){
        return  ResponseEntity.ok(registrationService.registerStudentToCourse(studentId, courseId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RegistrationDTO>> getAllRegistrations(){
        List<RegistrationDTO> registrationDTOs = registrationService.getAllRegistrations();
        return ResponseEntity.ok(registrationDTOs);
    }

    @GetMapping("/student/{studentId}/courses")
    public ResponseEntity<List<CourseDTO>> getCoursesByStudent(@PathVariable Long studentId) {
        List<CourseDTO> courses = registrationService.getCoursesByStudentId(studentId);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/course/{courseId}/students")
    public ResponseEntity<List<StudentDTO>> getStudentsByCourse(@PathVariable Long courseId) {
        List<StudentDTO> students = registrationService.getStudentsByCourseId(courseId);
        return ResponseEntity.ok(students);
    }
}

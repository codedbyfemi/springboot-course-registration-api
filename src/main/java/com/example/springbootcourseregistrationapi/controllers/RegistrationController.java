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
    public ResponseEntity<RegistrationDTO> register(@RequestParam String studentMatriculationNumber, @RequestParam String courseCode){
        return  ResponseEntity.ok(registrationService.registerStudentToCourse(studentMatriculationNumber, courseCode));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RegistrationDTO>> getAllRegistrations(){
        List<RegistrationDTO> registrationDTOs = registrationService.getAllRegistrations();
        return ResponseEntity.ok(registrationDTOs);
    }

    @GetMapping("/student/courses")
    public ResponseEntity<List<CourseDTO>> getCoursesByStudent(@RequestParam String studentMatriculationNumber) {
        List<CourseDTO> courses = registrationService.getCoursesByStudentMatriculationNumber(studentMatriculationNumber);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/course/students")
    public ResponseEntity<List<StudentDTO>> getStudentsByCourse(@RequestParam String courseCode) {
        List<StudentDTO> students = registrationService.getStudentsByCourseCode(courseCode);
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/unregister")
    public ResponseEntity<String> unregisterStudentFromCourse(
            @RequestParam String studentMatriculationNumber,
            @RequestParam String courseCode
    ) {
        registrationService.unRegisterStudentFromCourse(studentMatriculationNumber, courseCode);
        return ResponseEntity.ok("Student unregistered from course");
    }

}

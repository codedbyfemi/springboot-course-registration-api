package com.example.springbootcourseregistrationapi.controllers;

import com.example.springbootcourseregistrationapi.dto.RegistrationDTO;
import com.example.springbootcourseregistrationapi.iService.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private IRegistrationService registrationService;

    @PostMapping
    public ResponseEntity<RegistrationDTO> register(@RequestParam Long studentId, @RequestParam Long courseId){
        return  ResponseEntity.ok(registrationService.registerStudentToCourse(studentId, courseId));
    }
}

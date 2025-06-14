package com.example.springbootcourseregistrationapi.controllers;

import com.example.springbootcourseregistrationapi.dto.CourseDTO;

import com.example.springbootcourseregistrationapi.iService.ICourseService;
import com.example.springbootcourseregistrationapi.models.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseDTO courseDTO) {
        Course course = courseService.createCourse(courseDTO);
        return ResponseEntity.ok().body(course);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAllCourses() {
        List<CourseDTO> courseDTOList = courseService.findAllCourses();
        return ResponseEntity.ok(courseDTOList);
    }
}

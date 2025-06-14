package com.example.springbootcourseregistrationapi.iService;

import com.example.springbootcourseregistrationapi.dto.CourseDTO;
import com.example.springbootcourseregistrationapi.models.Course;

import java.util.List;

public interface ICourseService {

    Course createCourse(CourseDTO courseDTO);

    List<CourseDTO> findAllCourses();
}

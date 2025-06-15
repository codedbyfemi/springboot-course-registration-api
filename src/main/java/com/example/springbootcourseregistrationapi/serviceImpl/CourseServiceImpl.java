package com.example.springbootcourseregistrationapi.serviceImpl;

import com.example.springbootcourseregistrationapi.dto.CourseDTO;
import com.example.springbootcourseregistrationapi.iService.ICourseService;
import com.example.springbootcourseregistrationapi.models.Course;
import com.example.springbootcourseregistrationapi.repositories.CourseRepo;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Course createCourse(CourseDTO courseDTO) {
        Course byCode = courseRepo.findByCode(courseDTO.getCode()).orElse(null);
        Course byTitle = courseRepo.findByTitle(courseDTO.getTitle()).orElse(null);
        if (byCode != null || byTitle != null) {
            throw new EntityExistsException("Course already exists");
        }

        Course course = new Course();
        course.setCode(courseDTO.getCode());
        course.setTitle(courseDTO.getTitle());
        course.setUnit(courseDTO.getUnit());
        return courseRepo.save(course);
    }

    @Override
    public List<CourseDTO> findAllCourses() {
        List<Course> courses = courseRepo.findAll();
        return toDTOList(courses);
    }

    public CourseDTO toDto(Course course) {
        return new CourseDTO(
                course.getId(),
                course.getCode(),
                course.getTitle(),
                course.getUnit()
        );
    }

    public List<CourseDTO> toDTOList(List<Course> courses) {
        return courses.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}

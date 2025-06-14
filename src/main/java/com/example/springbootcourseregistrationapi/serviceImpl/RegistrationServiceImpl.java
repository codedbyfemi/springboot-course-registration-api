package com.example.springbootcourseregistrationapi.serviceImpl;

import com.example.springbootcourseregistrationapi.dto.CourseDTO;
import com.example.springbootcourseregistrationapi.dto.RegistrationDTO;
import com.example.springbootcourseregistrationapi.dto.StudentDTO;
import com.example.springbootcourseregistrationapi.iService.IRegistrationService;
import com.example.springbootcourseregistrationapi.models.Course;
import com.example.springbootcourseregistrationapi.models.Registration;
import com.example.springbootcourseregistrationapi.models.Student;
import com.example.springbootcourseregistrationapi.repositories.CourseRepo;
import com.example.springbootcourseregistrationapi.repositories.RegistrationRepo;
import com.example.springbootcourseregistrationapi.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements IRegistrationService {

    @Autowired
    private RegistrationRepo registrationRepo;
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public RegistrationDTO registerStudentToCourse(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId).
                orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Optional<Registration> existing = registrationRepo.findByStudentAndCourse(student, course);
        if (existing.isPresent()) {
            throw new RuntimeException("Student already registered for this course");
        }

        Registration registration = new Registration();
        registration.setStudent(student);
        registration.setCourse(course);
        Registration saved = registrationRepo.save(registration);

        return new RegistrationDTO(
                saved.getId(),
                student.getMatricNo(),
                student.getName(),
                course.getTitle(),
                course.getCode(),
                course.getUnit()
        );
    }

    @Override
    public List<RegistrationDTO> getAllRegistrations() {
        return List.of();
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(Long studentId) {
        return List.of();
    }

    @Override
    public List<StudentDTO> getStudentsByCourseId(Long courseId) {
        return List.of();
    }
}

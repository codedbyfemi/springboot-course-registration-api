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
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements IRegistrationService {

    @Autowired
    private RegistrationRepo registrationRepo;
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public RegistrationDTO registerStudentToCourse(String studentMatriculationNumber, String courseCode) {
        Student student = studentRepo.findByMatricNo(studentMatriculationNumber).
                orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepo.findByCode(courseCode)
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
        List<Registration> registrations = registrationRepo.findAll();
        return toDTOList(registrations);
    }

    @Override
    public List<CourseDTO> getCoursesByStudentMatriculationNumber(String studentMatriculationNumber) {
        Student student = studentRepo.findByMatricNo(studentMatriculationNumber).orElseThrow(() -> new RuntimeException("Student not found"));
        List<Registration> registrations = registrationRepo.findByStudent(student);

        return registrations.stream()
                .map(reg -> new CourseDTO(
                        reg.getCourse().getId(),
                        reg.getCourse().getTitle(),
                        reg.getCourse().getCode(),
                        reg.getCourse().getUnit()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentsByCourseCode(String courseCode) {
        Course course = courseRepo.findByCode(courseCode)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        List<Registration> registrations = registrationRepo.findByCourse(course);

        return registrations.stream()
                .map(reg -> new StudentDTO(
                        reg.getStudent().getId(),
                        reg.getStudent().getName(),
                        reg.getStudent().getMatricNo()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void unRegisterStudentFromCourse(String studentMatriculationNumber, String courseCode) {
        Student student = studentRepo.findByMatricNo(studentMatriculationNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepo.findByCode(courseCode)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Registration reg = registrationRepo.findByStudentAndCourse(student, course)
                .orElseThrow(() -> new RuntimeException("Registration not found"));

        registrationRepo.delete(reg);
    }

    public RegistrationDTO toDTO(Registration registration) {
        return new RegistrationDTO(
                registration.getId(),
                registration.getStudent().getMatricNo(),
                registration.getStudent().getName(),
                registration.getCourse().getTitle(),
                registration.getCourse().getCode(),
                registration.getCourse().getUnit()
        );
    }

    public List<RegistrationDTO> toDTOList(List<Registration> registrationList) {
        return registrationList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());

    }
}

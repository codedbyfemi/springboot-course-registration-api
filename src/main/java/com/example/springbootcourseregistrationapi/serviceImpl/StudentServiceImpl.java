package com.example.springbootcourseregistrationapi.serviceImpl;

import com.example.springbootcourseregistrationapi.dto.StudentDTO;
import com.example.springbootcourseregistrationapi.iService.IStudentService;
import com.example.springbootcourseregistrationapi.models.Student;
import com.example.springbootcourseregistrationapi.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student createStudent(StudentDTO student) {
        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setMatricNo(student.getMatricNo());
        studentRepo.save(student1);
        return student1;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return toDTOList(students);
    }

    public StudentDTO toDTO (Student student){
        return new StudentDTO(
            student.getId(),
            student.getName(),
            student.getMatricNo()
        );
    }

    public List<StudentDTO> toDTOList(List<Student> students) {
        return students.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}

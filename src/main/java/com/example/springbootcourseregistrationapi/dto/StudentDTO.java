package com.example.springbootcourseregistrationapi.dto;

import com.example.springbootcourseregistrationapi.models.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private String matricNo;

}

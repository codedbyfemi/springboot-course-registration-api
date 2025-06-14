package com.example.springbootcourseregistrationapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
    private Long id;
    private String studentMatriculationNumber;
    private String studentName;
    private String courseTitle;
    private String courseCode;
    private int courseUnit;
}

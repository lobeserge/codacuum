package com.codacuum.springbootcrud.service;

import com.codacuum.springbootcrud.dto.CreateStudentRequest;
import com.codacuum.springbootcrud.dto.StudentDetailsResponse;
import com.codacuum.springbootcrud.dto.UpdateStudentNameRequest;

public interface StudentService {
    void addStudent(CreateStudentRequest createStudentRequest);
    StudentDetailsResponse getStudentById(Long id);
    void updateStudentName(Long id, UpdateStudentNameRequest updateStudentNameRequest);
    void deleteStudentById(Long id);
}

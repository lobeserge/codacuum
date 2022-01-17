package com.codacuum.springbootcrud.service.serviceImpl;

import com.codacuum.springbootcrud.dto.CreateStudentRequest;
import com.codacuum.springbootcrud.dto.StudentDetailsResponse;
import com.codacuum.springbootcrud.dto.UpdateStudentNameRequest;
import com.codacuum.springbootcrud.model.Student;
import com.codacuum.springbootcrud.repository.StudentRepository;
import com.codacuum.springbootcrud.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student();
        student.setName(createStudentRequest.getName());
        student.setEmail(createStudentRequest.getEmail());
        student.setAge(createStudentRequest.getAge());
        student.setDepartment(createStudentRequest.getDepartment());
        student.setAddress(createStudentRequest.getAddress());
        studentRepository.save(student);
    }

    @Override
    public StudentDetailsResponse getStudentById(Long id) {

        StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            studentDetailsResponse.setName(student.getName());
            studentDetailsResponse.setEmail(student.getEmail());
            studentDetailsResponse.setAddress(student.getAddress());
            studentDetailsResponse.setDepartment(student.getDepartment());
            studentDetailsResponse.setId(student.getId());
            studentDetailsResponse.setAge(student.getAge());
        }
        return studentDetailsResponse;
    }

    @Override
    public void updateStudentName(Long id, UpdateStudentNameRequest updateStudentNameRequest) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            student.setName(updateStudentNameRequest.getName());
            studentRepository.save(student);
        }
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}

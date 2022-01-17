package com.codacuum.springbootcrud.controller;

import com.codacuum.springbootcrud.dto.CreateStudentRequest;
import com.codacuum.springbootcrud.dto.StudentDetailsResponse;
import com.codacuum.springbootcrud.dto.UpdateStudentNameRequest;
import com.codacuum.springbootcrud.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    ResponseEntity<?> addStudent(@RequestBody CreateStudentRequest createStudentRequest){
        studentService.addStudent(createStudentRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    ResponseEntity<StudentDetailsResponse> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateStudentName(@PathVariable Long id, @RequestBody UpdateStudentNameRequest updateStudentNameRequest){
        studentService.updateStudentName(id,updateStudentNameRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;  // Import ResponseEntity
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;  // For validation annotations

import org.springframework.http.HttpStatus;

@RestController 
public class StudentController {

    @Autowired
    private StudentService studentService; 

    @PostMapping("/postdata")
    public ResponseEntity<Student> postdata(@Valid @RequestBody Student student) {
        // Save student and return the response with status CREATED (201)
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }
}
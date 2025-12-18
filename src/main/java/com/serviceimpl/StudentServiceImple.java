package com.example.demo.Serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.respository.StudentRespository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImple implements StudentService {

    @Autowired
    StudentRespository studentRespository;

    @Override
    public Student saveStudent(Student student) {
        return studentRespository.save(student);
    }
}
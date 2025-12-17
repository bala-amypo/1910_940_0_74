package com.example.aiml.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aiml.entity.Student;

public interface StudentRespository extends JpaRepository<Student,Long>{
 
    
}
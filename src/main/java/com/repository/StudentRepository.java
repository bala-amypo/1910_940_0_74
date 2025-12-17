package com.example.aiml.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aiml.entity.Student;
@Repository
public interface StudentRespository extends JpaRepository<Student,Long>{
 
    
}
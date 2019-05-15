package com.example.majormanage.repository;

import com.example.majormanage.entity.Student;

import java.util.List;

public interface StudentRepositoryCustom {
    List<Student> searchStudentByAge();
}

package com.example.majormanage.service;

import com.example.majormanage.entity.Student;
import com.example.majormanage.repository.StudentRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Service
public class StudentRepositoryImpl implements StudentRepositoryCustom {
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> searchStudentByAge() {
        List<Student> list=entityManager.createNativeQuery("select * from student ",Student.class).getResultList();
       return list;

    }
}

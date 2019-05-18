package com.example.majormanage.service;

import com.example.majormanage.entity.QStudent;
import com.example.majormanage.entity.Student;
import com.example.majormanage.repository.StudentRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService{
    @Autowired
    StudentRepository studentReposity;
   public Collection<Student> findStudentByNameOrderByAgeDesc(String name){
       return studentReposity.findStudentByNameOrderByAgeDesc(name);
    }
    public List<Student> search(){
      return studentReposity.searchStudentByAge();
    }
    public Iterable<Student> findAll(String name,Integer a){
        QStudent student=QStudent.student;
        Predicate predicate=student.name.startsWith(name).and(student.age.eq(a));
      Iterable<Student> students=studentReposity.findAll(predicate);
      System.out.println("修改一句话");
      return students;

    }
    public Student getOne(int id){
        Student id1 = studentReposity.getOne(id);
        return id1;
    }
}

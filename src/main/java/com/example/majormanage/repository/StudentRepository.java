package com.example.majormanage.repository;

import com.example.majormanage.entity.Student;
import com.example.majormanage.service.StudentRepositoryImpl;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;


@Repository
public interface  StudentRepository extends JpaRepository<Student,Integer>,StudentRepositoryCustom,QuerydslPredicateExecutor<Student> {
     Collection<Student> findStudentByNameOrderByAgeDesc(String naem);
    Collection<Student> readAllByAgeGreaterThanEqual(Integer age);
    Integer countByName(String naem);
    Iterable<Student> findAll(Predicate var1);
   /* List<Student> searchStudentByAge();*/
}

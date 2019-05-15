package com.example.majormanage;

import com.example.majormanage.entity.Major;
import com.example.majormanage.entity.Student;
import com.example.majormanage.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MajormanageApplicationTests {
    @Autowired
    StudentService studentService;
    @Test
    public void findStudentByNameOrderByAgeDesc(){
        Iterable<Student> test = studentService.findAll("蒋",22);
        for(Student student:test){
            System.out.println(student.getName());
        }
    }
}

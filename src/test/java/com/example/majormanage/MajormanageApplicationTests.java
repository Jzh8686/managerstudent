package com.example.majormanage;

import com.example.majormanage.entity.Major;
import com.example.majormanage.entity.Student;
import com.example.majormanage.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Optional;
@EnableCaching
@RunWith(SpringRunner.class)
@SpringBootTest
public class MajormanageApplicationTests {
    @Autowired
    StudentService studentService;
    @Autowired
    RedisTemplate<String,Student> redisTemplate;
    @Test
    public void findStudentByNameOrderByAgeDesc(){
        Iterable<Student> test = studentService.findAll("蒋",22);
        for(Student student:test){
            System.out.println(student.getName());
        }
    }
 /*   @Test public void testRedis(){
        int a=1;
        Optional<Student> studet=studentService.getOne(a);
        redisTemplate.opsForValue().set(a,new Student());
        System.out.println("插入");
    }*/
    @Cacheable(cacheNames = "student",key="#id")
    public void get(int id){
        System.out.println(studentService.getOne(id).getName());
        System.out.println("开始");
    }

    @Test
    public void test(){
        for(int i=0;i<5;i++){
            get(18);
        }
    }
}

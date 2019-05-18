package com.example.majormanage.controller;


import com.example.majormanage.entity.Person;
import com.example.majormanage.entity.Student;
import com.example.majormanage.repository.PersonRepository;
import com.example.majormanage.repository.StudentRepository;
import com.example.majormanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class MajorController {
    @Autowired
    StudentRepository studentReposity;
    @Autowired
    StudentService studentService;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    RedisTemplate redisTemplate;
    //登陆
    @RequestMapping("login")
    public String login(Model model,@RequestParam String username, @RequestParam String password, HttpSession session){
        if(!StringUtils.isEmpty(username)&&!StringUtils.isEmpty(password)) {
            session.setAttribute("user",username);
            return "forward:/studentlist";
        }
        else{
            model.addAttribute("error","请输入账号密码");
        return "index";
        }
    }
    @RequestMapping("/peoplesss")
    @ResponseBody
    public List<Person> getAll(){
        return personRepository.findAll();
    }
    //查询某个学生

    //把查询结果进行缓存，默认的key为数据的主键
    @Cacheable(cacheNames = "student",key ="#id" )
    @RequestMapping("student/{id}")
    @ResponseBody
    public Student getOne(@PathVariable("id")int id) {
        return  studentService.getOne(id);
    }
      @Cacheable(cacheNames = "student",key = "#root.methodName")
      @RequestMapping("/students1")
      @ResponseBody
      public List<Student> findStudentByName(){
       List<Student> studentByName = studentService.search();
          return studentByName;
      }
      @RequestMapping("/query")
      @ResponseBody
      public Iterable<Student> testQueryDsl(@RequestParam(value = "name")String name,@RequestParam(value = "age")Integer age){
        return studentService.findAll(name,age);
      }
      @RequestMapping("/countstudentbyname/{name}")
    @ResponseBody
    public Integer countStudentByName(@PathVariable String name){
        Integer result=studentReposity.countByName(name);
        return result;
    }
    @RequestMapping("/studentlist")
    public String getStudent(Model model){
        model.addAttribute("students",studentReposity.findAll());
        return "list";
    }
    //插入
    @RequestMapping("/insert")
    public String insertStudent(Student student){
      studentReposity.save(student);
      return "forward:/studentlist";
    }
    //删除
    @RequestMapping("delete/{id}")
    public String deleteStudent(@PathVariable  Integer id){
      studentReposity.deleteById(id);
        return "forward:/studentlist";
    }
    //更新
    @RequestMapping("update/student")
    public String updateStudent(Student student){
      studentReposity.saveAndFlush(student);
        return "forward:/studentlist";
    }
}

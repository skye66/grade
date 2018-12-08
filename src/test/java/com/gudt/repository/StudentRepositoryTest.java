package com.gudt.repository;

import com.gudt.dataobject.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/5 20:59
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;
    private String studentId = "3115007145";
    @Test
    public void insert(){
        Student student = new Student();
        student.setStudentId("31150071xx");
        student.setStudentName("斯凯");
        student.setStudentGender(0);
        student.setStudentCollege("应用数学学院");
        student.setStudentGrade("大四");
        Student result = repository.save(student);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByStudentId(){
        Student result =repository.findByStudentId(studentId);
        log.info("【学号】,result={}",result.getStudentId());
        Assert.assertEquals(result.getStudentId(), studentId);
    }
}
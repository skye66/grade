package com.gudt.repository;

import com.gudt.dataobject.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 10:06
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;
    private String teacherId = "211500xxxx";

    @Test
    public void save(){
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherId);
        teacher.setTeacherGender(1);
        teacher.setTeacherName("lxy");
        teacher.setTeacherPosition("教师");
        teacher.setTeacherTitle("教授");
        Teacher result = repository.save(teacher);
        log.info("【添加】,result={}",result.getTeacherId());
        Assert.assertNotNull(result);
    }
    @Test
    public void findByTeacherId(){
        repository.findByTeacherId(teacherId);
    }
}
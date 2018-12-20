package com.gudt.service.impl;

import com.gudt.vo.StudentVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/20 9:19
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    private StudentServiceImpl service;

    @Test
    public void findListStudent() {
        List<StudentVo> studentVoList = service.findListStudent();
        Assert.assertNotEquals(0,studentVoList.size());
    }
}
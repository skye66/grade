package com.gudt.service.impl;

import com.gudt.dataobject.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/7 8:54
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {

    @Autowired
    private CourseServiceImpl courseService;
    @Test
    public void create() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void find() {
    }

    @Test
    public void list() {
        Page<Course> coursePage = courseService.list(0,10);
        Assert.assertNotEquals(0,coursePage.getContent().size());
    }
}
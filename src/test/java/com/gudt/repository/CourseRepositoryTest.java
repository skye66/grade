package com.gudt.repository;

import com.gudt.dataobject.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 9:41
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository repository;

    private String courseId = "20181206";
    private String teacherId = "xly";

    @Test
    public void save(){
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseName("软件工程");
        course.setCoursePeriod(4);
        course.setCourseCredit(2);
        course.setTeacherId(teacherId);
        Course result = repository.save(course);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCourseId(){
        Course result = repository.findByCourseId(courseId);
        Assert.assertEquals(courseId, result.getCourseId());
    }
    @Test
    public void findByCourserIdList(){
        List<Course> courseList = repository.findByCourseIdIn(Arrays.asList("03165130","03242260"));
        Assert.assertNotEquals(0, courseList.size());
    }
}
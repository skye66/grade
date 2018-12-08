package com.gudt.service;

import com.gudt.dataobject.Course;
import org.springframework.data.domain.Page;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 19:33
 * @Version 1.0
 **/
public interface CourseService {
    Course create(Course course);
    Course update(Course course);
    void delete(String courseId);
    Course find(String courseId);
    Page<Course> list(int num, int size);
}

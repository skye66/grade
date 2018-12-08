package com.gudt.service.impl;

import com.gudt.dataobject.Course;
import com.gudt.enums.ResultEnum;
import com.gudt.exception.GradeException;
import com.gudt.repository.CourseRepository;
import com.gudt.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 19:33
 * @Version 1.0
 **/
@Service
@Slf4j
public class CourseServiceImpl  implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Course create(Course course) {
        if (course == null) throw new GradeException(ResultEnum.COURSE_IS_EMPTY);
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        //从数据库中查询courseId，获取该课程数据，并保存到数据库中
        String courseId = course.getCourseId();
        if (courseId == null) {
            log.error("【添加课程】，课程号为空");
            throw new GradeException(ResultEnum.COURSE_IS_EMPTY);
        }
        if (courseRepository.findByCourseId(courseId) == null){
            log.error("【添加课程】，课程不存在");
            throw new GradeException(ResultEnum.COURSE_IS_EMPTY);
        }
        Course result = courseRepository.save(course);
        return result;
    }

    @Override
    public void delete(String courseId) {
        if (courseId == null){
            log.error("【删除课程】课程号为空");
            throw new GradeException(ResultEnum.COURSE_ID_ERROR);
        }
        Course course = courseRepository.findByCourseId(courseId);
        if (course == null){
            log.error("【删除课程】课程不存在");
            throw new GradeException(ResultEnum.COURSE_IS_EMPTY);
        }
        courseRepository.delete(course);
    }

    @Override
    public Course find(String courseId) {
        if (courseId == null){
            log.error("【查找出错】课程号为空");
            throw new GradeException(ResultEnum.COURSE_ID_ERROR);
        }
        Course course = courseRepository.findByCourseId(courseId);
        if (course == null){
            log.error("【查找课程】课程不存在");
            throw new GradeException(ResultEnum.COURSE_IS_EMPTY);
        }
        return course;
    }

    @Override
    public Page<Course> list(int num, int size) {
        //从第0页开始
        PageRequest request = PageRequest.of(num-1, size);
        Page<Course> coursePage = courseRepository.findAll(request);
        return coursePage;
    }
}

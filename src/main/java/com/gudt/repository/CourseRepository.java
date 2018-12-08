package com.gudt.repository;

import com.gudt.dataobject.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 9:34
 * @Version 1.0
 **/
public interface CourseRepository extends JpaRepository<Course, String> {
    Course findByCourseId(String courseId);

    List<Course> findByCourseIdIn(List courseIdList);

}

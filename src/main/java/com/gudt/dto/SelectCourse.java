package com.gudt.dto;

import com.gudt.dataobject.Course;
import lombok.Data;

import java.util.List;

/**
 * @Description 学生选课信息，通过id包装数据
 * @Author Skye
 * @Date 2018/12/7 9:41
 * @Version 1.0
 **/
@Data
public class SelectCourse {
    /**
     * 学号
     */
    private String studentId;
    /**
     * 学生姓名
     */
    private String studentName;

    private List<Course> courseList;
}

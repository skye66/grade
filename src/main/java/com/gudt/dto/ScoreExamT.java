package com.gudt.dto;

import com.gudt.dataobject.Course;
import lombok.Data;

import java.util.List;

/**
 * @Description 学生的课程成绩
 * @Author Skye
 * @Date 2018/12/7 15:35
 * @Version 1.0
 **/
@Data
public class ScoreExamT {

    /**
     * 学号
     */
    private String studentId;
    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 课程成绩列表
     */
    private List<CourseScoreDTO> courseScoreDTO;
}

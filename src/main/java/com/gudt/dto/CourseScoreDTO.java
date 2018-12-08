package com.gudt.dto;

import lombok.Data;

/**
 * @Description 包含课程成绩
 * @Author Skye
 * @Date 2018/12/7 15:38
 * @Version 1.0
 **/
@Data
public class CourseScoreDTO {
    /**
     *课程名
     */
    private String courseName;
    /**
     *开课教师
     */
    private String teacherId;
    /**
     *学时
     */
    private Integer coursePeriod;
    /**
     *学分
     */
    private Integer courseCredit;

    /**
     * 学生课程成绩
     */
    private Integer studentScore;
}

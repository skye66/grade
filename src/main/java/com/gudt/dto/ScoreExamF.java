package com.gudt.dto;

import lombok.Data;

/**
 * @Description 学生选课记录传输对象
 * @Author Skye
 * @Date 2018/12/7 9:33
 * @Version 1.0
 **/
@Data
public class ScoreExamF {
    /**
     * 成绩号
     */
    private Integer scoreId;
    /**
     *课程号
     */
    private String courseId;
    /**
     *学号
     */
    private String studentId;
}

package com.gudt.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/8 10:36
 * @Version 1.0
 **/
@Data
public class ScoreVo {
    /**
     *课程号
     */
    @NotBlank(message = "课程号不能为空")
    private String courseId;
    /**
     *学号
     */
    @NotBlank(message = "学号不能为空")
    private String studentId;
    /**
     *是否参加考试，默认值为0，表示未参加，该门课程未到考核时间
     */
    private Integer isExam = 0;
    /**
     *学生的成绩，如果为考核则为空值，且不进行展示
     */
    @Min(value = 0, message = "请输入0-100的数值")
    @Max(value = 100, message = "请输入0-100的数值")
    private Integer studentScore;
}

package com.gudt.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description 课程表
 * @Author Skye
 * @Date 2018/12/6 9:17
 * @Version 1.0
 **/
@Entity
@Data
public class Course {
    /**
     * 课程号
     */
    @Id
    private String courseId;
    /**
     *课程名
     */
    @NotBlank(message = "课程名不能为空")
    private String courseName;
    /**
     *开课教师
     */
    @NotBlank(message = "授课教师不能为空")
    private String teacherId;
    /**
     *学时
     */
    @NotNull(message = "学时不能为空")
    private Integer coursePeriod;
    /**
     *学分
     */
    @NotNull(message = "学分不能为空")
    private Integer courseCredit;
}

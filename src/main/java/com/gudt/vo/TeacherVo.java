package com.gudt.vo;

import lombok.Data;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/8 9:48
 * @Version 1.0
 **/
@Data
public class TeacherVo {

    /**
     * 教工id
     */
    private String teacherId;
    /**
     *教工名字
     */
    private String teacherName;
    /**
     *教工性别
     */
    private Integer teacherGender;
    /**
     *职称
     */
    private String teacherTitle;
    /**
     *职务
     */
    private String teacherPosition;
}

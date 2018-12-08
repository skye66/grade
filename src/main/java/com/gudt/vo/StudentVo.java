package com.gudt.vo;

import com.gudt.enums.CodeEnum;
import com.gudt.enums.StudentEnum;
import com.gudt.util.GetEnumUtil;
import lombok.Data;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 15:17
 * @Version 1.0
 **/
@Data
public class StudentVo {
    /**
     * 学号
     */
    private String studentId;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 学生性别0男1女
     */
    private Integer studentGender;


    /**
     * 性别 中文描述
     */
    private String gender;


    /**
     * 学生院系
     */
    private String studentCollege;
    /**
     *学生年级
     */
    private String studentGrade;
}

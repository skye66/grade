package com.gudt.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gudt.enums.StudentEnum;
import com.gudt.util.GetEnumUtil;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description 数据库中的实体类
 * @Author Skye
 * @Date 2018/12/5 20:46
 * @Version 1.0
 **/
@Data
@Entity
public class Student {
    /**
     * 学号
     */
    @Id
    private String studentId;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 学生姓名
     */
    @NotBlank(message = "学生姓名不能为空")
    private String studentName;
    /**
     * 学生性别0男1女
     */
    @NotNull(message = "性别不能为空")
    private Integer studentGender;
    /**
     * 学生院系
     */
    @NotBlank(message = "院系不能为空")
    private String studentCollege;
    /**
     *学生年级
     */
    @NotBlank(message = "学生年级不能为空")
    private String studentGrade;

    @JsonIgnore
    public StudentEnum getGenderEnum(){
        return GetEnumUtil.getEnum(StudentEnum.class, this.studentGender);
    }

}

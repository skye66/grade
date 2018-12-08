package com.gudt.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description 教师表
 * @Author Skye
 * @Date 2018/12/6 9:17
 * @Version 1.0
 **/
@Entity
@Data
public class Teacher {
    /**
     * 教工id
     */
    @Id
    private String teacherId;
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
     *教工名字
     */
    @NotBlank(message = "教工姓名不能为空")
    private String teacherName;
    /**
     *教工性别
     */
    @NotNull(message = "性别不能为空")
    private Integer teacherGender;
    /**
     *职称
     */
    @NotBlank(message = "职称不能为空")
    private String teacherTitle;
    /**
     *职务
     */
    @NotBlank(message = "职务不能为空")
    private String teacherPosition;
}

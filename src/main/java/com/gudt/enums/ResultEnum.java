package com.gudt.enums;

import lombok.Getter;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 14:56
 * @Version 1.0
 **/
@Getter
public enum ResultEnum implements CodeEnum{
    ERROR(0,"请求错误"),
    SUCCESS(1, "请求成功"),
    PARAM_ERROR(2,"参数错误"),
    LOGIN_ERROR(3,"用户名或密码错误"),
    USER_UN_LOGIN(4,"用户未登录"),
    STUDENT_ID_EMPTY(10,"学号不能为空"),
    STUDENT_ID_NOT_EXISTS(11,"学号不存在"),
    STUDENT_ID_EXISTS(12,"学号或用户名已存在"),
    STUDENT_REGISTER_ERROR(12, "创建失败"),
    COURSE_IS_EMPTY(20,"课程为空"),
    COURSE_ID_ERROR(21, "课程ID错误"),
    COURSE_PARAM(22,"课程参数不完整"),
    COURSE_DELETE_SUCCESS(23,"课程删除成功"),

    SCORE_EXAM_FALSE_ERROR(30,"不存在该选课"),
    SCORE_NOT_EXISTS(31,"不存在该成绩"),
    SCORE_NOT_EXISTS_OR_FINISH(32, "不存在该课程或者无法取消考核课程"),

    TEACHER_PARAM_ERROR(40,"教师参数错误"),
    TEACHER_NOT_EXISTS(41,"教师不存在"),
    TEACHER_EXISTS(42,"教师已存在"),
    TEACHER_USERNAME_EXISTS(43,"用户名已存在"),


    ;
    private Integer code;
    private String msg;
    private ResultEnum(Integer state, String msg){
        this.code = state;
        this.msg = msg;
    }
}

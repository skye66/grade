package com.gudt.enums;

import lombok.Getter;

/**
 * @Description 成绩
 * @Author Skye
 * @Date 2018/12/7 9:53
 * @Version 1.0
 **/
@Getter
public enum  ScoreEnum {
    IS_EXAM_FALSE(0, "未参加考核"),
    IS_EXAM_TRUE(1,"已参加考核"),
    ;
    private Integer code;
    private String description;
    private ScoreEnum(Integer code, String description){
        this.code = code;
        this.description = description;
    }
}

package com.gudt.enums;

import lombok.Getter;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 15:20
 * @Version 1.0
 **/
@Getter
public enum StudentEnum implements CodeEnum {
    MAN(0, "男"),
    FEMALE(1, "女"),
    ;
    private Integer code;
    private String  gender;
    private StudentEnum(Integer code, String gender){
        this.code = code;
        this.gender = gender;
    }
}

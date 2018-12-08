package com.gudt.exception;

import com.gudt.enums.ResultEnum;
import lombok.Getter;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 17:14
 * @Version 1.0
 **/
@Getter
public class GradeException extends RuntimeException {
    private Integer code;
    public GradeException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public GradeException(Integer code, String message){
        super(message);
        this.code = code;
    }
}

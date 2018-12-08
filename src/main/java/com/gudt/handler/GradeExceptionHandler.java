package com.gudt.handler;

import com.gudt.exception.GradeException;
import com.gudt.util.ResultVoUtil;
import com.gudt.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 捕获异常
 * @Author Skye
 * @Date 2018/12/6 17:26
 * @Version 1.0
 **/
@ControllerAdvice
public class GradeExceptionHandler {

    @ExceptionHandler(GradeException.class)
    @ResponseBody
    public ResultVo gradeExceptionHandle(GradeException e){
        return ResultVoUtil.error(e.getCode(),e.getMessage());
    }
}

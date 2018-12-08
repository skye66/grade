package com.gudt.handler;

import com.gudt.enums.ResultEnum;
import com.gudt.exception.AuthorizeException;
import com.gudt.exception.GradeException;
import com.gudt.util.ResultVoUtil;
import com.gudt.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description
 * @Author Skye
 * @Date 2018/12/8 17:26
 * @Version 1.0
 **/
@ControllerAdvice
@ResponseBody
public class AuthorizeExceptionHandler {

    @ExceptionHandler(AuthorizeException.class)
    public ResultVo authorizeHandler(){
        return ResultVoUtil.error(ResultEnum.USER_UN_LOGIN.getMsg());
    }
}

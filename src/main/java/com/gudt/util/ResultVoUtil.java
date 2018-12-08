package com.gudt.util;

import com.gudt.enums.ResultEnum;
import com.gudt.vo.ResultVo;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 14:57
 * @Version 1.0
 **/
public class ResultVoUtil<T> {

    public static<T> ResultVo<T> success(){
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setState(ResultEnum.SUCCESS.getCode());
        resultVo.setMsg(ResultEnum.SUCCESS.getMsg());
        resultVo.setData(null);
        return resultVo;
    }
    public static <T> ResultVo<T> success(T data){
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setState(ResultEnum.SUCCESS.getCode());
        resultVo.setMsg(ResultEnum.SUCCESS.getMsg());
        resultVo.setData(data);
        return resultVo;
    }
    public static <T> ResultVo<T> error(){
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setState(ResultEnum.ERROR.getCode());
        resultVo.setMsg(ResultEnum.ERROR.getMsg());
        resultVo.setData(null);
        return resultVo;
    }
    public static <T> ResultVo<T> error(String msg){
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setState(ResultEnum.ERROR.getCode());
        resultVo.setMsg(msg);
        resultVo.setData(null);
        return resultVo;
    }
    public static <T> ResultVo<T> error(int code, String msg){
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setState(code);
        resultVo.setMsg(msg);
        resultVo.setData(null);
        return resultVo;
    }
}

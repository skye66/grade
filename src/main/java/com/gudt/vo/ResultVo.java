package com.gudt.vo;

import lombok.Data;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 14:54
 * @Version 1.0
 **/
@Data

public class ResultVo<T> {
    private int state;
    private String msg;
    private T data;
}

package com.gudt.util;

import com.gudt.enums.CodeEnum;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 15:32
 * @Version 1.0
 **/
public class GetEnumUtil {

    public static<T extends CodeEnum> T getEnum(Class<T> enumClass, Integer code){
        for (T each: enumClass.getEnumConstants()) {
            if (each.getCode().equals(code)){
                return each;
            }
        }
        return null;
    }
}

package com.gudt.util;

import java.util.Random;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 20:11
 * @Version 1.0
 **/
public class RandomKeyUtil {

    public static String generate(){
        Random random = new Random();
        Integer randomInt = random.nextInt(90000)+10000;
        return (String.valueOf(randomInt) + System.currentTimeMillis()).substring(10);
    }
    public static String generateLongStr(){
        Random random = new Random();
        Integer randomInt = random.nextInt(90000)+10000;
        return (String.valueOf(randomInt) + System.currentTimeMillis());
    }
}

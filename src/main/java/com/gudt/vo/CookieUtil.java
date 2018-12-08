package com.gudt.vo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description cookie的设置和获取
 * @Author Skye
 * @Date 2018/12/6 16:49
 * @Version 1.0
 **/

public class CookieUtil {
    public static void setCookie(HttpServletResponse response,
                                 String key,
                                 String value,
                                 Integer expire){
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(expire);
         response.addCookie(cookie);
    }
    public static Cookie getCookie(HttpServletRequest request,
                                 String key){
        Cookie[] cookies = request.getCookies();
        Map<String, Cookie> map = getCookieMap(cookies);
        if (map.containsKey(key)){
            return map.get(key);
        }
        return null;
    }
    private static Map<String, Cookie> getCookieMap(Cookie[] cookies){
        Map<String, Cookie> map = new HashMap<>();
        if (cookies != null)
        for (Cookie cookie : cookies){
            map.put(cookie.getName(), cookie);
        }
        return map;
    }
}

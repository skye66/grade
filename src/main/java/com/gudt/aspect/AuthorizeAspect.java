package com.gudt.aspect;

import com.gudt.constant.CookieConstant;
import com.gudt.exception.AuthorizeException;
import com.gudt.vo.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/8 16:25
 * @Version 1.0
 **/
@Aspect
@Component
@Slf4j
public class AuthorizeAspect {

    @Autowired
    @Pointcut("execution(public * com.gudt.controller.*.*(..)) && !execution(public * com.gudt.controller.UserController.*(..))")
    public void verifyStudent(){

    }
    @Before("verifyStudent()")
    public void beforeStudent(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpSession session = request.getSession();
        //获取保存在会话中token属性值
        String tokenSession = (String) session.getAttribute(CookieConstant.TOKEN);
        //获取客户端中的值
        Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);
        String tokenCookie;
        try {
             tokenCookie = cookie.getValue();
        }catch (NullPointerException e){
            log.info("【用户未登录】");
            throw new AuthorizeException();
        }
        if (tokenCookie.equals(tokenSession)){
            log.info("【用户登陆正确】");
        }else throw new AuthorizeException();
    }

}

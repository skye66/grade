package com.gudt.controller;

import com.gudt.constant.CookieConstant;
import com.gudt.dataobject.Teacher;
import com.gudt.enums.ResultEnum;
import com.gudt.service.StudentService;
import com.gudt.service.TeacherService;
import com.gudt.util.RandomKeyUtil;
import com.gudt.util.ResultVoUtil;
import com.gudt.vo.CookieUtil;
import com.gudt.vo.ResultVo;
import com.gudt.vo.StudentVo;
import com.gudt.vo.TeacherVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Description 用户登陆控制器，管理学生、教师、管理员的登陆
 * @Author Skye
 * @Date 2018/12/8 10:03
 * @Version 1.0
 **/
@Controller
@ResponseBody
@Slf4j
public class UserController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    /**
     * 学生登陆
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/student_login")
    public ResultVo studentLogin(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 HttpServletResponse response,
                                 HttpSession session){
        //1.学生登陆
        if (Strings.isBlank(username)&&Strings.isBlank(password)){
            log.info("【用户登陆】登陆信息不完整");
            return ResultVoUtil.error(ResultEnum.PARAM_ERROR.getMsg());
        }
        StudentVo studentVo = studentService.find(username, password);
        //2.添加缓存信息
        CookieUtil.setCookie(response, CookieConstant.TOKEN,username+":"+password, CookieConstant.EXPIRE);
        session.setAttribute(CookieConstant.TOKEN, username+":"+password);
        return ResultVoUtil.success(studentVo);
    }

    /**
     * 教师登陆
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/teacher_login")
    public ResultVo teacherLogin(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 HttpServletResponse response,
                                 HttpSession session){
        //1.校验用户的账号和密码
        if (Strings.isBlank(username)&&Strings.isBlank(password)){
            log.info("【用户登陆】注册信息不完整");
            return ResultVoUtil.error(ResultEnum.PARAM_ERROR.getMsg());
        }
        TeacherVo teacherVo = teacherService.find(username, password);
        //2.添加缓存信息,将用户名添加到cookie中，会话中

        CookieUtil.setCookie(response, CookieConstant.TOKEN, username+":"+password, CookieConstant.EXPIRE);
        session.setAttribute(CookieConstant.TOKEN, username+":"+password);
        return ResultVoUtil.success(teacherVo);
    }

    /**
     * 教师注册
     * @param teacher
     * @param bindingResult
     * @return
     */
    @PostMapping("/teacher_register")
    public ResultVo teacherRegister(@Valid @RequestBody Teacher teacher,
                                    BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("【用户注册】注册信息不完整");
            return ResultVoUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        if(Strings.isEmpty(teacher.getTeacherId())){
            teacher.setTeacherId(RandomKeyUtil.generate());
        }
        TeacherVo teacherVo = teacherService.save(teacher);
        return ResultVoUtil.success(teacherVo);
    }



}

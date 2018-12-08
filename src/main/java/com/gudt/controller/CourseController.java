package com.gudt.controller;

import com.gudt.dataobject.Course;
import com.gudt.enums.ResultEnum;
import com.gudt.exception.GradeException;
import com.gudt.service.CourseService;
import com.gudt.util.RandomKeyUtil;
import com.gudt.util.ResultVoUtil;
import com.gudt.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description 课程管理控制器
 * @Author Skye
 * @Date 2018/12/6 11:22
 * @Version 1.0
 **/
@Controller
@RequestMapping("/course")
@Slf4j
@ResponseBody
public class CourseController {
    @Autowired
    private CourseService courseService;
    //添加课程
    @PostMapping("/add")
    public ResultVo<Course> add(@Valid Course course,
                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error(bindingResult.getFieldError().getDefaultMessage());
            throw new GradeException(ResultEnum.ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        course.setCourseId(RandomKeyUtil.generate());
        courseService.create(course);
        return ResultVoUtil.success(course);
    }
    //更新课程
    @PostMapping("/update")
    public ResultVo<Course> update(@Valid Course course,
                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error(bindingResult.getFieldError().getDefaultMessage());
            throw new GradeException(ResultEnum.ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        if (Strings.isBlank(course.getCourseId())){
            throw new GradeException(ResultEnum.COURSE_ID_ERROR);
        }
        Course result = courseService.update(course);
        return ResultVoUtil.success(result);
    }
    @GetMapping("/delete")
    public ResultVo delete(@RequestParam("course_id") String courseId){
        //todo 防止越权
        courseService.delete(courseId);
        return ResultVoUtil.success(ResultEnum.COURSE_DELETE_SUCCESS);
    }

    @GetMapping("/find")
    public ResultVo find(@RequestParam("course_id") String courseId){
        Course course = courseService.find(courseId);
        return ResultVoUtil.success(course);
    }

    @GetMapping("/list")
    public ResultVo list(@RequestParam(value = "num", defaultValue = "1") int num,
                         @RequestParam(value = "size", defaultValue = "10") int size){
        Page<Course> coursePage = courseService.list(num,size);
        return ResultVoUtil.success(coursePage);
    }

}

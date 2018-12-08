package com.gudt.service.impl;

import com.gudt.dataobject.Teacher;
import com.gudt.enums.ResultEnum;
import com.gudt.exception.GradeException;
import com.gudt.repository.TeacherRepository;
import com.gudt.service.TeacherService;
import com.gudt.vo.TeacherVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 教师service
 * @Author Skye
 * @Date 2018/12/8 9:38
 * @Version 1.0
 **/
@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * 保存（添加/更新）教师用户
     * @param teacher
     * @return
     */
    public TeacherVo save(Teacher teacher){
        if (teacherRepository.findByTeacherId(teacher.getTeacherId())!= null){
            log.info("【教师注册】存在该账号，teacherId ={}",teacher.getTeacherId());
            throw new GradeException(ResultEnum.TEACHER_EXISTS);
        }
        if (teacherRepository.findByUsername(teacher.getUsername())!= null){
            log.info("【教师注册】存在该用户名，username ={}",teacher.getUsername());
            throw new GradeException(ResultEnum.TEACHER_USERNAME_EXISTS);
        }
        TeacherVo teacherVo = new TeacherVo();
        if (teacher == null){
            throw new GradeException(ResultEnum.TEACHER_PARAM_ERROR);
        }
        Teacher result = teacherRepository.save(teacher);
        BeanUtils.copyProperties(result, teacherVo);
        return teacherVo;
    }

    /**
     * 删除教师
     * @param teacherId
     */
    public void delete(String teacherId){
        Teacher teacher = teacherRepository.findByTeacherId(teacherId);
        if (teacher == null ){
            throw new GradeException(ResultEnum.TEACHER_NOT_EXISTS);
        }
        teacherRepository.delete(teacher);
    }

    /**
     * 教师查找基本信息
     * @param teacherId
     * @return
     */
    public TeacherVo find(String teacherId){
        Teacher teacher = teacherRepository.findByTeacherId(teacherId);
        if (teacher == null){
            throw new GradeException(ResultEnum.TEACHER_NOT_EXISTS);
        }
        TeacherVo teacherVo = new TeacherVo();
        BeanUtils.copyProperties(teacher,teacherVo);
        return teacherVo;

    }

    /**
     * 教师登陆校验（用户名、密码）
     * @param username
     * @param password
     * @return
     */
    public TeacherVo find(String username, String password){

        Teacher teacher = teacherRepository.findByUsernameAndPassword(username,password);
        if (teacher == null){
            throw new GradeException(ResultEnum.LOGIN_ERROR);
        }
        TeacherVo teacherVo = new TeacherVo();
        BeanUtils.copyProperties(teacher,teacherVo);
        return teacherVo;
    }



}

package com.gudt.service.impl;

import com.gudt.dataobject.Student;
import com.gudt.enums.ResultEnum;
import com.gudt.exception.GradeException;
import com.gudt.repository.StudentRepository;
import com.gudt.service.StudentService;
import com.gudt.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 10:48
 * @Version 1.0
 **/
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public StudentVo findByStudentId(String studentId) {
        Student student = studentRepository.findByStudentId(studentId);
        if (student == null) {
            log.error("【查询学号】不存在该学号,studentId={}",studentId);
            throw new GradeException(ResultEnum.STUDENT_ID_NOT_EXISTS);
        }
        StudentVo studentVo = new StudentVo();
        BeanUtils.copyProperties(student, studentVo);
        studentVo.setGender(student.getGenderEnum().getGender());
        return studentVo;
    }

    /**
     * 登陆校验，通过用户名和密码
     * @param username
     * @param password
     * @return
     */
    public StudentVo find(String username, String password){
        Student student = studentRepository.findByUsernameAndPassword(username, password);
        if (student == null){
            throw new GradeException(ResultEnum.LOGIN_ERROR);
        }
        StudentVo studentVo = new StudentVo();
        BeanUtils.copyProperties(student, studentVo);
        return studentVo;
    }

    public StudentVo save(Student student){
         ;
        if (studentRepository.findByStudentId(student.getStudentId()) != null || studentRepository.findByStudentId(student.getStudentId()).getUsername() == student.getUsername()){
            throw new GradeException(ResultEnum.STUDENT_ID_EXISTS);
        }
        Student result = studentRepository.save(student);
        if (result == null){
            throw new GradeException(ResultEnum.STUDENT_REGISTER_ERROR);
        }
        StudentVo studentVo = new StudentVo();
        BeanUtils.copyProperties(result, studentVo);
        return studentVo;
    }
    public void delete(String studentId){
        Student student = studentRepository.findByStudentId(studentId);
        if (student == null) {
            log.error("【删除学生】不存在该学号, studentId = {}",studentId);
            throw new GradeException(ResultEnum.STUDENT_ID_NOT_EXISTS);
        }
        studentRepository.delete(student);
        log.info("【删除学生】删除成功，学号为={}",studentId);
    }
}

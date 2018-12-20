package com.gudt.service;

import com.gudt.dataobject.Student;
import com.gudt.vo.StudentVo;

import java.util.List;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 10:47
 * @Version 1.0
 **/

public interface StudentService {
    StudentVo findByStudentId(String studentId);
    StudentVo find(String username, String password);
    StudentVo save(Student student);
    void delete(String studentId);
    List<StudentVo> findListStudent();
}

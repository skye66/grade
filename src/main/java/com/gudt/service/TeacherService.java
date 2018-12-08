package com.gudt.service;

import com.gudt.dataobject.Teacher;
import com.gudt.vo.TeacherVo;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/8 9:38
 * @Version 1.0
 **/
public interface TeacherService {
    TeacherVo save(Teacher teacher);
    void delete(String teacherId);
    TeacherVo find(String teacherId);
    TeacherVo find(String username, String password);

}

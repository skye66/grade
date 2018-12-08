package com.gudt.repository;

import com.gudt.dataobject.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 9:34
 * @Version 1.0
 **/
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    Teacher findByTeacherId(String teacherId);
    Teacher findByUsernameAndPassword(String username, String password);
    Teacher findByUsername(String username);
}

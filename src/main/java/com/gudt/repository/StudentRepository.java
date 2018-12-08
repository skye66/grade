package com.gudt.repository;

import com.gudt.dataobject.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/5 20:56
 * @Version 1.0
 **/
public interface StudentRepository extends JpaRepository<Student, String> {

    /**
     * 通过学号查找
     * @param studentId
     * @return
     */
    Student findByStudentId(String studentId);

    Student findByUsernameAndPassword(String username, String password);

}

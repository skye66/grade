package com.gudt.repository;

import com.gudt.dataobject.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 9:34
 * @Version 1.0
 **/
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    List<Score> findByStudentIdAndIsExam(String studentId, Integer isExam);
    Score findByStudentIdAndCourseIdAndAndIsExam(String studentId, String courseId, Integer isExam);
}

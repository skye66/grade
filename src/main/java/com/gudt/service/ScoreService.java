package com.gudt.service;

import com.gudt.dataobject.Score;
import com.gudt.dto.ScoreExamF;
import com.gudt.dto.ScoreExamT;
import com.gudt.dto.SelectCourse;
import com.gudt.vo.ScoreVo;
import org.springframework.data.domain.Page;


/**
 * @Description 学生的成绩管理isExam为0时代表为参加考核，则表示学生已选课程，不参与成绩的计算
 * @Author Skye
 * @Date 2018/12/6 16:23
 * @Version 1.0
 **/

public interface ScoreService {
   Score create(String courseId, String studentId);
   Score find(String courseId,String studentId);//查找已考核
   ScoreExamF findIsExamFalse(String courseId, String studentId);
   ScoreExamT listIsExamTrue(String studentId);//学生管理通过学号查看自己的所有的成绩
   SelectCourse listIsExamFalse(String studentId);
   Page<Score> list();//教师端通过学生集合查看所有的成绩
   void deleteCourse(String courseId, String studentId);
   ScoreVo save(ScoreVo scoreVo);
}

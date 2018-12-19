package com.gudt.service.impl;

import com.gudt.dataobject.Course;
import com.gudt.dataobject.Score;
import com.gudt.dataobject.Student;
import com.gudt.dto.CourseScoreDTO;
import com.gudt.dto.ScoreExamF;
import com.gudt.dto.ScoreExamT;
import com.gudt.dto.SelectCourse;
import com.gudt.enums.ResultEnum;
import com.gudt.enums.ScoreEnum;
import com.gudt.exception.GradeException;
import com.gudt.repository.CourseRepository;
import com.gudt.repository.ScoreRepository;
import com.gudt.repository.StudentRepository;
import com.gudt.service.ScoreService;
import com.gudt.vo.ScoreVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 16:28
 * @Version 1.0
 **/
@Service
@Slf4j
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    /**
     * 创建一条选课记录，并isExam设置为0
     * @param courseId
     * @param studentId
     * @return
     */
    @Override
    public Score create(String courseId, String studentId) {

        Score score = new Score();
        score.setCourseId(courseId);
        score.setStudentId(studentId);
        return scoreRepository.save(score);
    }
    public ScoreVo save(ScoreVo scoreVo){
        Score score = new Score();
        BeanUtils.copyProperties(scoreVo, score);
        Score result = scoreRepository.save(score);
        BeanUtils.copyProperties(result, scoreVo);
        return scoreVo;
    }

    /**
     * 通过学号,课程号查找选课，不包含成绩
     * @param studentId
     * @return
     */
    @Override
    public ScoreExamF findIsExamFalse(String courseId,String studentId) {
        Score score = scoreRepository.findByStudentIdAndCourseIdAndAndIsExam(studentId, courseId,ScoreEnum.IS_EXAM_FALSE.getCode());
        if (score == null) {
            log.info("【查找选课】，选课不存在");
            throw new GradeException(ResultEnum.SCORE_EXAM_FALSE_ERROR);
        }
        ScoreExamF scoreExamF = new ScoreExamF();
        BeanUtils.copyProperties(score, scoreExamF);
        return scoreExamF;
    }

    /**
     * 通过学号，课程号查找课程成绩
     * @param studentId
     * @return
     */
    @Override
    public Score find(String courseId, String studentId) {
        Score score = scoreRepository.findByStudentIdAndCourseIdAndAndIsExam(studentId, courseId, ScoreEnum.IS_EXAM_TRUE.getCode());
        if (score == null){
            throw new GradeException(ResultEnum.SCORE_NOT_EXISTS);
        }
        return score;
    }

    /**
     * 学生通过学号查找课程成绩列表,
     * @param studentId
     * @return
     */
    @Override
    public ScoreExamT listIsExamTrue(String studentId) {
        ScoreExamT scoreExamT = new ScoreExamT();
        Student student = studentRepository.findByStudentId(studentId);
        if (student == null){
            log.error("【查询选课列表】学号不存在");
            throw new GradeException(ResultEnum.STUDENT_ID_NOT_EXISTS);
        }
        List<Score> scoreList = scoreRepository.findByStudentIdAndIsExam(studentId, ScoreEnum.IS_EXAM_TRUE.getCode());
        List<CourseScoreDTO> courseScoreDTOList = new ArrayList<>();
        //封装数据，每一遍历创建一个courseScoreDTO并保存成绩信息和课程的详细信息
        for (Score score : scoreList){
            CourseScoreDTO courseScoreDTO = new CourseScoreDTO();
            Course course = courseRepository.findByCourseId(score.getCourseId());
            BeanUtils.copyProperties(course, courseScoreDTO);
            courseScoreDTO.setStudentScore(score.getStudentScore());
            courseScoreDTOList.add(courseScoreDTO);
        }
        scoreExamT.setStudentName(student.getStudentName());
        scoreExamT.setStudentId(studentId);
        scoreExamT.setCourseScoreDTO(courseScoreDTOList);
        return scoreExamT;

    }

    /**
     * 学生通过学号查找选课列表
     * @param studentId
     * @return
     */
    @Override
    public SelectCourse listIsExamFalse(String studentId) {
        SelectCourse selectCourse = new SelectCourse();
        Student student = studentRepository.findByStudentId(studentId);
        if (student == null){
            log.error("【查询选课列表】学号不存在");
            throw new GradeException(ResultEnum.STUDENT_ID_NOT_EXISTS);
        }
        //1.获取学生选课的课程列表
        List<Score> scoreList = scoreRepository.findByStudentIdAndIsExam(studentId, ScoreEnum.IS_EXAM_FALSE.getCode());
        if (scoreList.isEmpty()){
            log.info("【查询选课列表】,学号{}尚未选课",studentId);
            throw new GradeException(ResultEnum.SCORE_EXAM_FALSE_ERROR);
        }
        List<String> courseIdList = new ArrayList<>();
        for (Score score: scoreList) {
            courseIdList.add(score.getCourseId());
        }
        //从courseIdList中在repository中取出相应的course对象
         List<Course> courseList = courseRepository.findByCourseIdIn(courseIdList);
        //遍历课程id集合，并添加到courseList中
        selectCourse.setStudentId(studentId);
        selectCourse.setStudentName(student.getStudentName());
        selectCourse.setCourseList(courseList);
        return selectCourse;
    }


    /**
     * 教师通过学生集合查找学生的成绩列表
     * @return
     */
    @Override
    public Page<Score> list() {

        return null;
    }

    /**
     * 取消选课
     * @param courseId
     * @param studentId
     */
    @Override
    public void deleteCourse(String courseId, String studentId) {

        Score score = scoreRepository.findByStudentIdAndCourseIdAndAndIsExam(studentId,courseId, ScoreEnum.IS_EXAM_FALSE.getCode());
        if (score == null){
            throw new GradeException(ResultEnum.SCORE_NOT_EXISTS_OR_FINISH);
        }
        scoreRepository.delete(score);
    }
}

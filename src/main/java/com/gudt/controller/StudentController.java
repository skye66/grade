package com.gudt.controller;

import com.gudt.dataobject.Score;
import com.gudt.dto.ScoreExamF;
import com.gudt.dto.SelectCourse;
import com.gudt.enums.ResultEnum;
import com.gudt.exception.GradeException;
import com.gudt.service.ScoreService;
import com.gudt.service.StudentService;
import com.gudt.util.ResultVoUtil;
import com.gudt.vo.ResultVo;
import com.gudt.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 10:18
 * @Version 1.0
 **/
@Controller
@RequestMapping("/student")
@ResponseBody
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ScoreService scoreService;

    /**
     * 查找学生的基本信息
     * @param studentId
     * @return
     */
    @GetMapping("/find")
    public ResultVo<StudentVo> find(@RequestParam("student_id") String studentId){
        if (studentId == null){
            throw new GradeException(ResultEnum.STUDENT_ID_EMPTY);
        }
        StudentVo studentVo = studentService.findByStudentId(studentId);
        return ResultVoUtil.success(studentVo);
    }
    /**
     * 学生选课，储存到成绩表中，isExam为0则为未到考核时间
     */
    @GetMapping("add_course")
    public ResultVo addCourse(@RequestParam("student_id") String studentId,
                          @RequestParam("course_id") String courseId){
        if (studentId == null && courseId == null){
            throw new GradeException(ResultEnum.STUDENT_ID_EMPTY);
        }

        Score score = scoreService.create(courseId,studentId);
        return ResultVoUtil.success(score);
    }
    /**
     * 学生查询课程成绩
     */
    @GetMapping("query_score")
    public ResultVo queryScore(@RequestParam("course_id") String courseId,
                           @RequestParam("student_id") String studentId){

        if (courseId != null && studentId !=null) {
            Score score = scoreService.find(courseId, studentId);
            return ResultVoUtil.success(score);
        }
        throw new GradeException(ResultEnum.PARAM_ERROR);
    }
    /**
     * 学生查询已选某一课程
     */
    @GetMapping("/query_select_course")
    public ResultVo querySelectCourse(@RequestParam("course_id") String courseId,
                                      @RequestParam("student_id") String studentId){
        if (courseId != null && studentId !=null) {
            ScoreExamF scoreExamF = scoreService.findIsExamFalse(courseId, studentId);
            return ResultVoUtil.success(scoreExamF);
        }
        throw new GradeException(ResultEnum.PARAM_ERROR);
    }

    /**
     * 查询学生已选的全部课程
     * @param studentId
     * @return
     */
    @GetMapping("/query_list_course")
    public ResultVo queryListCourse(@RequestParam("student_id") String studentId){
        if (studentId == null){
            throw new GradeException(ResultEnum.PARAM_ERROR);
        }
        SelectCourse selectCourse =  scoreService.listIsExamFalse(studentId);
        return ResultVoUtil.success(selectCourse);
    }
    /**
     * 查询学生所有的成绩信息
     */
    @GetMapping("query_list_score")
    public ResultVo queryListScore(@RequestParam("student_id") String studentId){
        if (studentId == null) throw new GradeException(ResultEnum.PARAM_ERROR);
        return ResultVoUtil.success(scoreService.listIsExamTrue(studentId));
    }

    /**
     * 取消已选课程，有成绩的无法取消
     */
    @GetMapping("/cancel_course")
    public ResultVo cancelCourse(@RequestParam("course_id") String courseId,
                                 @RequestParam("student_id") String studentId){
        if (courseId != null && studentId != null) {
            scoreService.deleteCourse(courseId, studentId);
            return ResultVoUtil.success();
        }
        throw new GradeException(ResultEnum.PARAM_ERROR);
    }



}

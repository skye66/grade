package com.gudt.controller;

import com.gudt.dataobject.Student;
import com.gudt.enums.ResultEnum;
import com.gudt.enums.ScoreEnum;
import com.gudt.exception.GradeException;
import com.gudt.service.ScoreService;
import com.gudt.service.StudentService;
import com.gudt.service.TeacherService;
import com.gudt.util.RandomKeyUtil;
import com.gudt.util.ResultVoUtil;
import com.gudt.vo.ResultVo;
import com.gudt.vo.ScoreVo;
import com.gudt.vo.TeacherVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description 教师控制器，查看基本信息，添加课程，评分等
 * @Author Skye
 * @Date 2018/12/6 10:19
 * @Version 1.0
 **/
@Controller
@RequestMapping("/teacher")
@ResponseBody
@Slf4j
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StudentService studentService;

    /**
     * 查看教工的基本信息
     * @param teacherId
     * @return
     */
    @GetMapping("/query")
    public ResultVo query(@RequestParam("teacher_id") String teacherId){
        if (teacherId == null) throw new GradeException(ResultEnum.PARAM_ERROR);
        TeacherVo teacherVo = teacherService.find(teacherId);
        return ResultVoUtil.success(teacherVo);
    }

    /**
     * 保存成绩（更新或添加）
     * @param scoreVo
     * @param bindingResult
     * @return
     */
    @PostMapping("/save_student_score")
    public ResultVo saveStudentScore(@Valid @RequestBody ScoreVo scoreVo,
                                     BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultVoUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        scoreVo.setIsExam(ScoreEnum.IS_EXAM_TRUE.getCode());
        ScoreVo result = scoreService.save(scoreVo);
        return ResultVoUtil.success(result);
    }

    /**
     * 教师新增学生
     * @param student
     * @param bindingResult
     * @return
     */
    @PostMapping("/add_student")
    public ResultVo studentRegister(@Valid @RequestBody Student student,
                                    BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("【用户注册】注册信息不完整");
            return ResultVoUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        if (Strings.isBlank(student.getStudentId())){
            student.setStudentId(RandomKeyUtil.generate());
        }
        return ResultVoUtil.success(studentService.save(student));
    }

    /**
     * 删除学生账号
     * @param studentId
     * @return
     */
    @GetMapping("/delete_student")
    public ResultVo deleteStudent(@RequestParam("student_id") String studentId){
        if (Strings.isBlank(studentId)){
            log.error("【删除学生】学号为空");
            throw new GradeException(ResultEnum.PARAM_ERROR);
        }
        studentService.delete(studentId);
        return ResultVoUtil.success();
    }
}

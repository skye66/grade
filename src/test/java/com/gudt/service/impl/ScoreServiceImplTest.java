package com.gudt.service.impl;

import com.gudt.dataobject.Score;
import com.gudt.dto.ScoreExamT;
import com.gudt.dto.SelectCourse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/7 14:52
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ScoreServiceImplTest {

    @Autowired
    private ScoreServiceImpl scoreService;
    private String studentId = "3115007145";
    @Test
    public void create() {
    }

    @Test
    public void findIsExamFalse() {
    }

    @Test
    public void find() {
    }

    @Test
    public void listIsExamTrue() {
         ScoreExamT scoreExamT = scoreService.listIsExamTrue(studentId);
         log.info("scoreExamT = {}",scoreExamT);
        Assert.assertNotEquals(0, scoreExamT.getCourseScoreDTO().size());
    }

    @Test
    public void listIsExamFalse() {
        SelectCourse selectCourse = scoreService.listIsExamFalse(studentId);
        Assert.assertNotEquals(0,selectCourse.getCourseList().size());
    }


}
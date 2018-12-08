package com.gudt.repository;

import com.gudt.dataobject.Score;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author Skye
 * @Date 2018/12/6 9:51
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreRepositoryTest {
    @Autowired
    private ScoreRepository repository;
    private String studentId = "3115007145";
    @Test
    public void save(){
        Score score = new Score();
        score.setIsExam(1);
        score.setStudentId(studentId);
        score.setStudentScore(100);
        score.setCourseId("20181206");
        Score result = repository.save(score);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByStudentId(){
    }
}
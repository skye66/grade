package com.gudt.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Description 成绩表
 * @Author Skye
 * @Date 2018/12/6 9:18
 * @Version 1.0
 **/
@Entity
@Data
public class Score {
    /**
     * 成绩号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scoreId;
    /**
     *课程号
     */
    private String courseId;
    /**
     *学号
     */
    private String studentId;
    /**
     *是否参加考试，默认值为0，表示未参加，该门课程未到考核时间
     */
    private Integer isExam = 0;
    /**
     *学生的成绩，如果为考核则为空值，且不进行展示
     */
    private Integer studentScore;

}

package com.wh.workSubmission.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

/**
 * <p>
 * 
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
public class Course extends Model<Course> {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("course_no")
    private String courseNo;
    @TableField("course_name")
    private String courseName;
    @TableField("profession_no")
    private String professionNo;
    @TableField("teacher_no")
    private String teacherNo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfessionNo() {
        return professionNo;
    }

    public void setProfessionNo(String professionNo) {
        this.professionNo = professionNo;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Course{" +
        "id=" + id +
        ", courseNo=" + courseNo +
        ", courseName=" + courseName +
        ", professionNo=" + professionNo +
        ", teacherNo=" + teacherNo +
        "}";
    }
}

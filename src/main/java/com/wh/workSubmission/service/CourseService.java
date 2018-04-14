package com.wh.workSubmission.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.entity.Course;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
public interface CourseService extends IService<Course> {

    void addCourse(Course course);

    Page<Course> findAll(Page page, String keyword, String teacherNo, String professionNo, String type, String id);

    void updateCourse(Course course);

    List<Course> findByTeacher(String teacherNo);
}

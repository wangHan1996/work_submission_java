package com.wh.workSubmission.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.entity.Course;
import com.wh.workSubmission.exception.WorkException;
import com.wh.workSubmission.mapper.CourseMapper;
import com.wh.workSubmission.service.CourseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void addCourse(Course course) {
        Course course1 = courseMapper.selectByCourseNo(course.getCourseNo());
        if (course1 != null) {
            throw new WorkException("该课程号已存在");
        }
        courseMapper.insert(course);
    }

    @Override
    public Page<Course> findAll(Page page, String keyword, String teacherNo, String professionNo,
                                String type, String id) {
        return page.setRecords(courseMapper.selectCourse(page, keyword,teacherNo, professionNo,type, id));

    }

    @Override
    public void updateCourse(Course course) {
        Course course1 = courseMapper.selectByCourseNo(course.getCourseNo());
        if (course1 != null && !course1.getId().equals(course.getId())) {
            throw new WorkException("该课程号已存在");
        }
        courseMapper.updateById(course);
    }

    @Override
    public List<Course> findByTeacher(String teacherNo) {
        List<Course> courseList = courseMapper.selectByTeacher(teacherNo);
        return courseList;
    }
}

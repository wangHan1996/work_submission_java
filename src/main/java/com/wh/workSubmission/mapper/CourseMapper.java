package com.wh.workSubmission.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wh.workSubmission.entity.Course;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper extends BaseMapper<Course> {

    Course selectByCourseNo(@Param("courseNo") String courseNo);

    List<Course> selectCourse(Pagination page,
                              @Param("keyword") String keyword,
                              @Param("teacherNo") String teacherNo,
                              @Param("professionNo") String professionNo,
                              @Param("type") String type,
                              @Param("id") String id);

    List<Course> selectByTeacher(@Param("teacherNo") String teacherNo);
}

package com.wh.workSubmission.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.annotation.Access;
import com.wh.workSubmission.dto.Response;
import com.wh.workSubmission.entity.Course;
import com.wh.workSubmission.util.ResponseUtil;
import com.wh.workSubmission.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public Response findAll(@RequestParam(value = "currentPage") String currentPage,
                            @RequestParam(value = "size") String size,
                            @RequestParam(value = "keyword",required = false) String keyword,
                            @RequestParam(value = "teacherNo",required = false) String teacherNo,
                            @RequestParam(value = "professionNo",required = false) String professionNo,
                            @RequestParam(value = "type",required = false) String type,
                            @RequestParam(value = "id",required = false) String id) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<Course> coursePage = courseService.findAll(page, keyword,teacherNo, professionNo, type, id);
        return ResponseUtil.success(coursePage);
    }

    @GetMapping("/teacher")
    public Response findByTeacher(String teacherNo) {
        List<Course> courseList = courseService.findByTeacher(teacherNo);
        return ResponseUtil.success(courseList);
    }

    @GetMapping("/{id}")
    public Response getOne(@PathVariable("id") String id) {
        Course course = courseService.selectById(id);
        return ResponseUtil.success(course);
    }

    @PostMapping("")
    @Access(authorities = {"0"})
    public Response addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseUtil.success();
    }

    @DeleteMapping("/{id}")
    @Access(authorities = {"0"})
    public Response deleteOne(@PathVariable("id") String id) {
        courseService.deleteById(id);
        return ResponseUtil.success();
    }

    @PutMapping("")
    @Access(authorities = {"0"})
    public Response updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
        return ResponseUtil.success();
    }

}


package com.wh.workSubmission.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.annotation.Access;
import com.wh.workSubmission.dto.Response;
import com.wh.workSubmission.entity.Teacher;
import com.wh.workSubmission.util.ResponseUtil;
import com.wh.workSubmission.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("")
    public Response findAll(@RequestParam(value = "currentPage") String currentPage,
                            @RequestParam(value = "size") String size,
                            @RequestParam(value = "keyword") String keyword,
                            @RequestParam(value = "type",required = false) String type,
                            @RequestParam(value = "id",required = false) String id) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<Teacher> teacherPage = teacherService.findAll(page, keyword, type, id);
        return ResponseUtil.success(teacherPage);
    }

    @GetMapping("/{id}")
    public Response getOne(@PathVariable("id") String id) {
        Teacher teacher = teacherService.selectById(id);
        return ResponseUtil.success(teacher);
    }

    @PostMapping("")
    @Access(authorities = {"0"})
    public Response addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseUtil.success();
    }

    @DeleteMapping("/{id}")
    @Access(authorities = {"0"})
    public Response deleteOne(@PathVariable("id") String id) {
        teacherService.deleteById(id);
        return ResponseUtil.success();
    }

    @PutMapping("")
    @Access(authorities = {"0"})
    public Response updateCourse(@RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return ResponseUtil.success();
    }
}


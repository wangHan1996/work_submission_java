package com.wh.workSubmission.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.annotation.Access;
import com.wh.workSubmission.dto.Response;
import com.wh.workSubmission.entity.Student;
import com.wh.workSubmission.util.ResponseUtil;
import com.wh.workSubmission.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public Response findAll(@RequestParam(value = "currentPage") String currentPage,
                            @RequestParam(value = "size") String size,
                            @RequestParam(value = "keyword") String keyword,
                            @RequestParam(value = "classesNo",required = false) String classesNo,
                            @RequestParam(value = "type",required = false) String type,
                            @RequestParam(value = "id",required = false) String id) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<Student> studentPage = studentService.findAll(page, keyword,classesNo, type, id);
        return ResponseUtil.success(studentPage);
    }

    @GetMapping("/{id}")
    public Response getOne(@PathVariable("id") String id) {
        Student student = studentService.selectById(id);
        return ResponseUtil.success(student);
    }

    @PostMapping("")
    @Access(authorities = {"0"})
    public Response addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseUtil.success();
    }

    @DeleteMapping("/{id}")
    @Access(authorities = {"0"})
    public Response deleteOne(@PathVariable("id") String id) {
        studentService.deleteById(id);
        return ResponseUtil.success();
    }

    @PutMapping("")
    @Access(authorities = {"0"})
    public Response updateCourse(@RequestBody Student student) {
        studentService.updateStudent(student);
        return ResponseUtil.success();
    }
}


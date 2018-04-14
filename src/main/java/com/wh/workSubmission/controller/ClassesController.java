package com.wh.workSubmission.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.annotation.Access;
import com.wh.workSubmission.dto.Response;
import com.wh.workSubmission.entity.Classes;
import com.wh.workSubmission.service.ClassesService;
import com.wh.workSubmission.util.ResponseUtil;
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
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @GetMapping("")
    public Response findAll(@RequestParam(value = "currentPage") String currentPage,
                            @RequestParam(value = "size") String size,
                            @RequestParam(value = "keyword") String keyword,
                            @RequestParam(value = "professionNo",required = false) String professionNo,
                            @RequestParam(value = "type",required = false) String type,
                            @RequestParam(value = "id",required = false) String id) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<Classes> classesPage = classesService.findAll(page, keyword, professionNo, type, id);
        return ResponseUtil.success(classesPage);
    }

    @GetMapping("/course")
    public Response findClassesByCourse(@RequestParam(value = "courseNo") String courseNo) {
        List<Classes> classesList = classesService.findClassesByCourse(courseNo);
        return ResponseUtil.success(classesList);
    }


    @GetMapping("/{id}")
    public Response getOne(@PathVariable("id") String id) {
        Classes classes = classesService.selectById(id);
        return ResponseUtil.success(classes);
    }

    @PostMapping("")
    @Access(authorities = {"0"})
    public Response addClasses(@RequestBody Classes classes) {
        classesService.addClasses(classes);
        return ResponseUtil.success();
    }

    @DeleteMapping("/{id}")
    @Access(authorities = {"0"})
    public Response deleteOne(@PathVariable("id") String id) {
        classesService.deleteById(id);
        return ResponseUtil.success();
    }

    @PutMapping("")
    @Access(authorities = {"0"})
    public Response updateCourse(@RequestBody Classes classes) {
        classesService.updateClasses(classes);
        return ResponseUtil.success();
    }
}


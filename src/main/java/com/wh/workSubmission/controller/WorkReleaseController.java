package com.wh.workSubmission.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.dto.Response;
import com.wh.workSubmission.dto.WorkReleaseDto;
import com.wh.workSubmission.entity.WorkRelease;
import com.wh.workSubmission.util.ResponseUtil;
import com.wh.workSubmission.service.WorkReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workRelease")
public class WorkReleaseController {
    @Autowired
    private WorkReleaseService workReleaseService;

    @GetMapping("")
    public Response queryWorkRelease(@RequestParam(value = "currentPage") String currentPage,
                                     @RequestParam(value = "size") String size,
                                     @RequestParam(value = "keyword",required = false) String keyword,
                                     @RequestParam(value = "teacherNo",required = false) String teacherNo,
                                     @RequestParam(value = "studentNo",required = false) String studentNo,
                                     @RequestParam(value = "professionNo",required = false) String professionNo
                                     ) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<WorkReleaseDto> workReleasePage = workReleaseService.findAll(page, keyword, teacherNo, studentNo,professionNo);
        return ResponseUtil.success(workReleasePage);
    }

    @PostMapping("")
    public Response addWorkRelease(@RequestBody WorkRelease workRelease) {
        workReleaseService.addWorkRelease(workRelease);
        return ResponseUtil.success();
    }



}


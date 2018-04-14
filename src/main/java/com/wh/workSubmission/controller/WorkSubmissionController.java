package com.wh.workSubmission.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.dto.Response;
import com.wh.workSubmission.dto.WorkSubmissionDto;
import com.wh.workSubmission.entity.WorkSubmission;
import com.wh.workSubmission.util.ResponseUtil;
import com.wh.workSubmission.service.WorkSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@RestController
@RequestMapping("/workSubmission")
public class WorkSubmissionController {
    @Autowired
    private WorkSubmissionService workSubmissionService;

    @GetMapping("")
    public Response queryWorkSubmission(@RequestParam(value = "currentPage") String currentPage,
                                        @RequestParam(value = "size") String size,
                                        @RequestParam(value = "workNo",required = false) String workNo,
                                        @RequestParam(value = "keyword",required = false) String keyword,
                                        @RequestParam(value = "teacherNo",required = false) String teacherNo,
                                        @RequestParam(value = "courseNo",required = false) String courseNo,
                                        @RequestParam(value = "status",required = false) String status,
                                        @RequestParam(value = "studentNo",required = false) String studentNo,
                                        @RequestParam(value = "classesNo",required = false) String classesNo) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<WorkSubmissionDto> workSubmissionDtoPage = workSubmissionService.findWorkSubmission(page, workNo, keyword,
                teacherNo,courseNo,studentNo,status,classesNo);
        return ResponseUtil.success(workSubmissionDtoPage);
    }

    @PostMapping("")
    public Response addWorkSubmission(@RequestBody WorkSubmission workSubmission) {
        workSubmissionService.addWorkSubmission(workSubmission);
        return ResponseUtil.success();
    }

    @PostMapping("/correcting")
    public Response correctingWork(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        String status = map.get("status");
        workSubmissionService.correctingWork(id,status);
        return ResponseUtil.success();
    }
}


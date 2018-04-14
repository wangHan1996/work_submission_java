package com.wh.workSubmission.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.dto.Constant;
import com.wh.workSubmission.dto.WorkSubmissionDto;
import com.wh.workSubmission.entity.WorkSubmission;
import com.wh.workSubmission.mapper.WorkSubmissionMapper;
import com.wh.workSubmission.util.BaseUtil;
import com.wh.workSubmission.service.WorkSubmissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkSubmissionServiceImpl extends ServiceImpl<WorkSubmissionMapper, WorkSubmission> implements WorkSubmissionService {
    @Autowired
    private WorkSubmissionMapper workSubmissionMapper;

    @Override
    public Page<WorkSubmissionDto> findWorkSubmission(Page page, String workNo, String keyword, String teacherNo,
                                                      String courseNo, String studentNo, String status, String classesNo) {
        List<WorkSubmissionDto> workSubmissionDtoList = workSubmissionMapper.selectWorkSubmission(page, workNo,
                keyword,teacherNo,courseNo,studentNo,status,classesNo);
        for (WorkSubmissionDto workSubmissionDto : workSubmissionDtoList) {
            workSubmissionDto.setStatus(BaseUtil.getStatusValue(workSubmissionDto.getStatus()));
        }
        return page.setRecords(workSubmissionDtoList);
    }

    @Override
    public void addWorkSubmission(WorkSubmission workSubmission) {
        WorkSubmission tempWorkSubmission = workSubmissionMapper
                .selectByWorkNoStudentNo(workSubmission.getWorkNo(),workSubmission.getStudentNo());
        if (tempWorkSubmission != null) {
            tempWorkSubmission.setSubmissionTime(LocalDateTime.now());
            tempWorkSubmission.setStatus(Constant.STATE_YTJ);
            tempWorkSubmission.setAddress(workSubmission.getAddress());
            workSubmissionMapper.updateById(tempWorkSubmission);
        } else {
            workSubmission.setSubmissionTime(LocalDateTime.now());
            workSubmission.setStatus(Constant.STATE_YTJ);
            workSubmissionMapper.insert(workSubmission);
        }
    }

    @Override
    public void correctingWork(String id, String status) {
        workSubmissionMapper.correctionWork(id, status);
    }

}

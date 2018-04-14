package com.wh.workSubmission.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.dto.WorkReleaseDto;
import com.wh.workSubmission.entity.WorkRelease;
import com.wh.workSubmission.mapper.WorkReleaseMapper;
import com.wh.workSubmission.util.BaseUtil;
import com.wh.workSubmission.util.DateUtil;
import com.wh.workSubmission.service.WorkReleaseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class WorkReleaseServiceImpl extends ServiceImpl<WorkReleaseMapper, WorkRelease> implements WorkReleaseService {

    @Autowired
    private WorkReleaseMapper workReleaseMapper;


    @Override
    public void addWorkRelease(WorkRelease workRelease) {
        String workNo = DateUtil.formatNowDate() + workRelease.getCourseNo();
        workRelease.setWorkNo(workNo);
        workRelease.setReleaseTime(LocalDateTime.now());
        workReleaseMapper.insert(workRelease);
    }

    @Override
    public Page<WorkReleaseDto> findAll(Page page, String keyword, String teacherNo, String studentNo, String professionNo) {
        List<WorkReleaseDto> workReleaseList;
        if (StringUtils.isEmpty(professionNo)) {
            workReleaseList = workReleaseMapper.selectWorkRelease(page, keyword, teacherNo, professionNo);
        }else {
            workReleaseList = workReleaseMapper.selectWorkReleaseForStudent(page, keyword, studentNo, professionNo);
            workReleaseList.removeIf(workReleaseDto -> workReleaseDto.getStatus().equals("2"));
            for (WorkReleaseDto workReleaseDto : workReleaseList) {
                workReleaseDto.setStatus(BaseUtil.getStatusValue(workReleaseDto.getStatus()));
            }
        }
        return page.setRecords(workReleaseList);
    }
}

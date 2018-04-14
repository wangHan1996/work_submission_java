package com.wh.workSubmission.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.dto.WorkSubmissionDto;
import com.wh.workSubmission.entity.WorkSubmission;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
public interface WorkSubmissionService extends IService<WorkSubmission> {

    Page<WorkSubmissionDto> findWorkSubmission(Page page, String workNo, String keyword, String teacherNo,
                                               String courseNo, String studentNo, String status, String classesNo);

    void addWorkSubmission(WorkSubmission workSubmission);

    void correctingWork(String id, String status);

}

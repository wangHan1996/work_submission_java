package com.wh.workSubmission.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.dto.WorkReleaseDto;
import com.wh.workSubmission.entity.WorkRelease;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
public interface WorkReleaseService extends IService<WorkRelease> {

    void addWorkRelease(WorkRelease workRelease);

    Page<WorkReleaseDto> findAll(Page page, String keyword, String teacherNo, String studentNo, String professionNo);
}

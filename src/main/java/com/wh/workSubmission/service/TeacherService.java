package com.wh.workSubmission.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.entity.Teacher;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
public interface TeacherService extends IService<Teacher> {

    Page<Teacher> findAll(Page page, String keyword, String type, String id);

    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);
}

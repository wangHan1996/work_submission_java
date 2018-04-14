package com.wh.workSubmission.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.entity.Teacher;
import com.wh.workSubmission.exception.WorkException;
import com.wh.workSubmission.mapper.TeacherMapper;
import com.wh.workSubmission.service.TeacherService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public void addTeacher(Teacher teacher) {
        Teacher teacher1 = teacherMapper.selectByUsername(teacher.getUsername());
        if (teacher1 != null) {
            throw new WorkException("该教师号已存在");
        }
        teacher.setPassword(teacher.getUsername());
        teacherMapper.insert(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        Teacher teacher1 = teacherMapper.selectByUsername(teacher.getUsername());
        if (teacher1 != null && !teacher1.getId().equals(teacher.getId())) {
            throw new WorkException("该教师号已存在");
        }
        Teacher oldTeacher = teacherMapper.selectById(teacher.getId());
        if (StringUtils.isEmpty(teacher.getPassword())) {
            teacher.setPassword(oldTeacher.getPassword());
        }
        teacherMapper.updateById(teacher);
    }

    @Override
    public Page<Teacher> findAll(Page page, String keyword, String type, String id) {
        List<Teacher> teacherList = teacherMapper.selectTeacher(page, keyword,type, id);
        for (Teacher teacher : teacherList) {
            teacher.setPassword("");
        }
        return page.setRecords(teacherList);
    }
}

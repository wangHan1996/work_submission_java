package com.wh.workSubmission.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.entity.Student;
import com.wh.workSubmission.exception.WorkException;
import com.wh.workSubmission.mapper.StudentMapper;
import com.wh.workSubmission.service.StudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public void addStudent(Student student) {
        Student student1 = studentMapper.selectByUsername(student.getUsername());
        if (student1 != null) {
            throw new WorkException("该学号已存在");
        }
        student.setPassword(student.getUsername());
        studentMapper.insert(student);
    }

    @Override
    public void updateStudent(Student student) {
        Student student1 = studentMapper.selectByUsername(student.getUsername());
        if (student1 != null && !student1.getId().equals(student.getId())) {
            throw new WorkException("该学号已存在");
        }
        Student oldStudent = studentMapper.selectById(student.getId());
        if (StringUtils.isEmpty(student.getPassword())) {
            student.setPassword(oldStudent.getPassword());
        }
        studentMapper.updateById(student);
    }

    @Override
    public Page<Student> findAll(Page page, String keyword, String classesNo, String type, String id) {
        List<Student> studentList = studentMapper.selectStudent(page, keyword, classesNo,type, id);
        for (Student student : studentList) {
            student.setPassword("");
        }
        return page.setRecords(studentList);
    }
}

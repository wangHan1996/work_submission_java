package com.wh.workSubmission.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.entity.Classes;
import com.wh.workSubmission.exception.WorkException;
import com.wh.workSubmission.mapper.ClassesMapper;
import com.wh.workSubmission.service.ClassesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;


    @Override
    public void addClasses(Classes classes) {
        Classes classes1 = classesMapper.selectByClassesNo(classes.getClassesNo());
        if (classes1 != null) {
            throw new WorkException("该班级号已存在");
        }
        classesMapper.insert(classes);
    }

    @Override
    public void updateClasses(Classes classes) {
        Classes classes1 = classesMapper.selectByClassesNo(classes.getClassesNo());
        if (classes1 != null && !classes1.getId().equals(classes.getId())) {
            throw new WorkException("该班级号已存在");
        }

        classesMapper.updateById(classes);
    }

    @Override
    public List<Classes> findClassesByCourse(String courseNo) {

        return classesMapper.selectByCourse(courseNo);
    }

    @Override
    public Page<Classes> findAll(Page page, String keyword, String professionNo, String type, String id) {
        List<Classes> classesList = classesMapper.selectClasses(page, keyword, professionNo,type, id);
        return page.setRecords(classesList);
    }
}

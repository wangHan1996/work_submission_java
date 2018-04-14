package com.wh.workSubmission.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.entity.Classes;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
public interface ClassesService extends IService<Classes> {
    Page findAll(Page page, String keyword, String professionNo, String type, String id);

    void addClasses(Classes classes);

    void updateClasses(Classes classes);

    List<Classes> findClassesByCourse(String courseNo);
}

package com.wh.workSubmission.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.entity.Profession;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
public interface ProfessionService extends IService<Profession> {
    Page findAll(Page page, String keyword, String type, String id);

    void addProfession(Profession profession);

    void updateProfession(Profession profession);
}

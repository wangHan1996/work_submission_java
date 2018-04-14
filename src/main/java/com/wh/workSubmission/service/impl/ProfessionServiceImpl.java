package com.wh.workSubmission.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.entity.Profession;
import com.wh.workSubmission.exception.WorkException;
import com.wh.workSubmission.mapper.ProfessionMapper;
import com.wh.workSubmission.service.ProfessionService;
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
public class ProfessionServiceImpl extends ServiceImpl<ProfessionMapper, Profession> implements ProfessionService {

    @Autowired
    private ProfessionMapper professionMapper;


    @Override
    public void addProfession(Profession profession) {
        Profession profession1 = professionMapper.selectByProfessionNo(profession.getProfessionNo());
        if (profession1 != null) {
            throw new WorkException("该专业号已存在");
        }
        professionMapper.insert(profession);
    }

    @Override
    public void updateProfession(Profession profession) {
        Profession profession1 = professionMapper.selectByProfessionNo(profession.getProfessionNo());
        if (profession1 != null && !profession1.getId().equals(profession.getId())) {
            throw new WorkException("该专业号已存在");
        }

        professionMapper.updateById(profession);
    }

    @Override
    public Page<Profession> findAll(Page page, String keyword, String type, String id) {
        List<Profession> professionList = professionMapper.selectProfession(page, keyword,type, id);

        return page.setRecords(professionList);
    }
}

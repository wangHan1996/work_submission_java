package com.wh.workSubmission.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wh.workSubmission.entity.Profession;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionMapper extends BaseMapper<Profession> {

    Profession selectByProfessionNo(@Param("professionNo") String professionNo);

    List<Profession> selectProfession(Pagination page,
                                      @Param("keyword") String keyword,
                                      @Param("type") String type,
                                      @Param("id") String id);
}

package com.wh.workSubmission.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wh.workSubmission.entity.Classes;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClassesMapper extends BaseMapper<Classes> {

    Classes selectByClassesNo(@Param("classesNo") String classesNo);

    List<Classes> selectClasses(Pagination page,
                                @Param("keyword") String keyword,
                                @Param("professionNo") String professionNo,
                                @Param("type") String type,
                                @Param("id") String id);

    List<Classes> selectByCourse(@Param("courseNo") String courseNo);
}

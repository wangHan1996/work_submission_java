package com.wh.workSubmission.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wh.workSubmission.dto.WorkReleaseDto;
import com.wh.workSubmission.entity.WorkRelease;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@Repository
public interface WorkReleaseMapper extends BaseMapper<WorkRelease> {

    List<WorkReleaseDto> selectWorkRelease(Pagination page,
                                           @Param("keyword") String keyword,
                                           @Param("teacherNo") String teacherNo,
                                           @Param("professionNo") String professionNo);

    List<WorkReleaseDto> selectWorkReleaseForStudent(Pagination page,
                                                     @Param("keyword") String keyword,
                                                     @Param("studentNo") String studentNo,
                                                     @Param("professionNo") String professionNo);
}

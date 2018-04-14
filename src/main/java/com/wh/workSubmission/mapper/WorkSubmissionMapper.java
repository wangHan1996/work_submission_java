package com.wh.workSubmission.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wh.workSubmission.dto.WorkSubmissionDto;
import com.wh.workSubmission.entity.WorkSubmission;
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
public interface WorkSubmissionMapper extends BaseMapper<WorkSubmission> {

    List<WorkSubmissionDto> selectWorkSubmission(Pagination page,
                                                 @Param("workNo") String workNo,
                                                 @Param("keyword") String keyword,
                                                 @Param("teacherNo") String teacherNo,
                                                 @Param("courseNo") String courseNo,
                                                 @Param("studentNo") String studentNo,
                                                 @Param("status") String status,
                                                 @Param("classesNo") String classesNo);

    void correctionWork(@Param("id") String id, @Param("status") String status);

    WorkSubmission selectByWorkNoStudentNo(@Param("workNo") String workNo, @Param("studentNo") String studentNo);
}

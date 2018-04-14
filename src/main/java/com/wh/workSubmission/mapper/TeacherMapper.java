package com.wh.workSubmission.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wh.workSubmission.entity.Teacher;
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
public interface TeacherMapper extends BaseMapper<Teacher> {

    Teacher selectByUsername(@Param("username") String username);

    List<Teacher> selectTeacher( Pagination page,
                                 @Param("keyword") String keyword,
                                 @Param("type") String type,
                                 @Param("id") String id);

    void updatePassword(@Param("id") String id, @Param("newPassword") String newPassword);
}

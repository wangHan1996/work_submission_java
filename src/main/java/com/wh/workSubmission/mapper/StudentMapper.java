package com.wh.workSubmission.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wh.workSubmission.entity.Student;
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
public interface StudentMapper extends BaseMapper<Student> {

    Student selectByUsername(@Param("username") String username);

    List<Student> selectStudent(Pagination page,
                                @Param("keyword") String keyword,
                                @Param("classesNo") String classesNo,
                                @Param("type") String type,
                                @Param("id") String id);

    void updatePassword(@Param("id") String id, @Param("newPassword") String newPassword);

    String selectProfessionId(@Param("studentId") String studentId);
}

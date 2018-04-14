package com.wh.workSubmission.mapper;

import com.wh.workSubmission.entity.Admin;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

    Admin selectByUsername(@Param("username") String username);

    void updatePassword(@Param("id") String id, @Param("newPassword") String newPassword);
}

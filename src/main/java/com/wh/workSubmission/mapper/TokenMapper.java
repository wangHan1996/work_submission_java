package com.wh.workSubmission.mapper;

import com.wh.workSubmission.entity.Token;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-04-14
 */
@Repository
public interface TokenMapper extends BaseMapper<Token> {

    Token selectByToken(@Param("token") String token);

    Token selectByUserId(@Param("userId") String userId);
}

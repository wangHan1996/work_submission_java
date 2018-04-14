package com.wh.workSubmission.service;

import com.wh.workSubmission.dto.User;
import com.wh.workSubmission.entity.Token;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author null123
 * @since 2018-04-14
 */
public interface TokenService extends IService<Token> {
    String createToken(User user);

    boolean checkToken(String token);

    String getUserId(String token);

    String getUserType(String token);

}

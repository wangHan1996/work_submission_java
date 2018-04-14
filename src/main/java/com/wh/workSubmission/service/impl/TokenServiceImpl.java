package com.wh.workSubmission.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wh.workSubmission.dto.User;
import com.wh.workSubmission.entity.Admin;
import com.wh.workSubmission.entity.Student;
import com.wh.workSubmission.entity.Teacher;
import com.wh.workSubmission.entity.Token;
import com.wh.workSubmission.exception.WorkException;
import com.wh.workSubmission.mapper.TokenMapper;
import com.wh.workSubmission.service.TokenService;
import com.wh.workSubmission.util.CodecUtil;
import com.wh.workSubmission.util.ResponseUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-04-14
 */
@Service
public class TokenServiceImpl extends ServiceImpl<TokenMapper, Token> implements TokenService {
    @Autowired
    private TokenMapper tokenMapper;
    /**
     * 创建token
     */
    @Override
    public String createToken(User user) {
        String userId = user.getId();
        String userType = user.getType();
        Token oldUserToken = tokenMapper.selectByUserId(userId);
        // 数据库中有该电话号码的token
        if (oldUserToken != null ) {
            // 设置新的token
            String newToken = CodecUtil.createUUID();
            oldUserToken.setToken(newToken);
            oldUserToken.setUserType(userType);
            // 更新数据库
            tokenMapper.updateById(oldUserToken);
            return newToken;
        }
        String token = CodecUtil.createUUID();
        Token userToken = new Token();
        userToken.setUserId(userId);
        userToken.setToken(token);
        userToken.setUserType(userType);
        tokenMapper.insert(userToken);
        return token;
    }

    /**
     * 检查token
     */
    @Override
    public boolean checkToken(String token) {
        if (StringUtils.isEmpty(token)) {
            ResponseUtil.notLogin();
        }
        Token temp = tokenMapper.selectByToken(token);
        return temp != null;
    }

    /**
     * 根据token获得用户id
     */
    @Override
    public String getUserId(String token) {
        if (StringUtils.isEmpty(token)) {
            ResponseUtil.notLogin();
        }
        Token temp = tokenMapper.selectByToken(token);
        return temp.getUserId();
    }

    /**
     * 获得用户类型
     */
    @Override
    public String getUserType(String token) {
        if (StringUtils.isEmpty(token)) {
            ResponseUtil.notLogin();
        }
        Token temp = tokenMapper.selectByToken(token);
        return temp.getUserType();
    }
}

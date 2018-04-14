package com.wh.workSubmission.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author null123
 * @since 2018-04-14
 */
public class Token extends Model<Token> {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("user_id")
    private String userId;
    @TableField("user_type")
    private String userType;
    private String token;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Token{" +
        "id=" + id +
        ", userId=" + userId +
        ", userType=" + userType +
        ", token=" + token +
        "}";
    }
}

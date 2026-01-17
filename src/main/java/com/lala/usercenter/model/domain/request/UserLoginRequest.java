package com.lala.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author XiFeng
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 619478210377212407L;

    public String userAccount;

    public String userPassword;

}

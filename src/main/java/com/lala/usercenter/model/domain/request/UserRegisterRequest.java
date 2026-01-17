package com.lala.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author XiFeng
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 619478210377212407L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String planetCode;

}

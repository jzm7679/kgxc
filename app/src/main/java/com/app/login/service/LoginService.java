package com.app.login.service;

import com.common.entity.user.User;

/**
 * @author JiaZM
 */
public interface LoginService {

    /**
     * 登录
     * @param username 用户名
     * @param pwd 密码
     * @return
     * */
    User login(String username, String pwd);

}

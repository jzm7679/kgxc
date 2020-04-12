package com.common.hessian.user;

import com.common.entity.user.User;

/**
 * @author JiaZM
 * @date 2020/4/10 13:52
 */
public interface UserHessian {

    /**
     * 查询用户
     * @param username 用户名
     * @param pwd 密码
     * @return 用户
     * */
    User findUser(String username, String pwd);
}

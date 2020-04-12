package com.server.user.server.impl;

import com.common.entity.user.User;
import com.common.hessian.user.UserHessian;
import org.springframework.stereotype.Service;

/**
 * @author JiaZM
 * @date 2020/4/10 13:55
 */
@Service
public class UserHessianImpl implements UserHessian {

    @Override
    public User findUser(String username, String pwd) {
        return User.builder().id(1L).username("admin").pwd("admin").build();
    }
}

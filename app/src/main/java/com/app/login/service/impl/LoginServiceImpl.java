package com.app.login.service.impl;

import com.app.login.service.LoginService;
import com.common.entity.user.User;
import com.common.hessian.user.UserHessian;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JiaZM
 * @date 2020/4/10 14:19
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginServiceImpl implements LoginService {

    private final UserHessian userHessian;

    @Override
    public User login(String username, String pwd) {
        User user = userHessian.findUser(username, pwd);

        return user;
    }
}

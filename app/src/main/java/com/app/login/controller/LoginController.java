package com.app.login.controller;

import com.app.config.BaseController;
import com.app.login.service.LoginService;
import com.common.entity.user.User;
import com.common.util.jwt.JwtUtil;
import com.common.util.result.ResCode;
import com.common.util.result.ResultDto;
import com.common.util.result.SystemParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author JiaZM
 * @date 2020/4/10 14:15
 */
@Api(tags = "登录")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController extends BaseController {

    private final LoginService loginService;

    @ApiOperation("登录 - 用户名&密码")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "用户名", required = true,
            paramType = "query", dataType = "String", defaultValue = "admin"),
        @ApiImplicitParam(name = "pwd", value = "密码", required = true,
            paramType = "query", dataType = "String", defaultValue = "admin")
    })
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultDto<User> login(@RequestParam(value = "username", required = true) String username,
        @RequestParam(value = "pwd", required = true) String pwd) {
        ResCode resCode;
        User user = null;
        SystemParams sp = null;
        try {
            user = loginService.login(username, pwd);
            if(user != null) {
                String token = JwtUtil.sign(user.getUsername(), user.getPwd());
                sp = SystemParams.builder().currentTime(new Date()).token(token).build();
            }
            resCode = ResCode.SUCCESS;
        } catch (Exception e) {

            resCode = ResCode.ERROR;
        }

        return result(resCode, user, sp);
    }

}

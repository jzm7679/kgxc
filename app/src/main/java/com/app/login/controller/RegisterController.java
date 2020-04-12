package com.app.login.controller;

import com.app.config.BaseController;
import com.common.util.result.ResCode;
import com.common.util.result.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiaZM
 * @date 2020/4/11 22:21
 */
@Api(tags = "注册")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RegisterController extends BaseController {

    @ApiOperation("注册账户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "用户名", required = true,
                paramType = "query", dataType = "String"),
        @ApiImplicitParam(name = "pwd", value = "密码", required = true,
                paramType = "query", dataType = "String"),
        @ApiImplicitParam(name = "verifyCode", value = "验证码", required = true,
                paramType = "query", dataType = "String")
    })
    @PostMapping(value = "/" +
            "")
    public ResultDto register(@RequestParam(value = "username", required = true) String username,
           @RequestParam(value = "pwd", required = true) String pwd,
           @RequestParam(value = "verifyCode", required = true) String verifyCode) {
        ResCode resCode = null;
        try {

            resCode = ResCode.REGISTER_SUCCESS;
        } catch (Exception e) {

            resCode = ResCode.ERROR;
        }
        return result(resCode);
    }

}

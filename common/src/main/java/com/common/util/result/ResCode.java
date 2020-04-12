package com.common.util.result;

/**
 * 状态码
 * @author JiaZM
 * @date 2020/4/10 15:25
 */
public enum ResCode {

    /**
     * 状态码
     * */
    SUCCESS(0, "成功"),
    ERROR(1, "失败"),

    LOGIN_FAIL(110, "登录失败"),
    AUTH_FAIL(120, "认证失败"),

    REGISTER_SUCCESS(0, "注册成功"),
    REGISTER_FAIL_PHONE_EXIST(130, "手机号已存在"),
    REGISTER_FAIL_VERIFY_CODE_NOT_EXIST_OR_EXPIRE(130, "验证码不存在或已过期");


    private final Integer code;
    private final String message;

    ResCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

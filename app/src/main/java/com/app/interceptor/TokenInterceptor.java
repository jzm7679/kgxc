package com.app.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.common.util.jwt.JwtUtil;
import com.common.util.result.ResCode;
import com.common.util.result.ResultDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author JiaZM
 * @date 2020/4/10 20:56
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    /**
     * 无需拦截的URL
     * */
    public static final List<String> NOT_INTERCEPT_URL = Stream.of(
            "/login",
            "/register"
        ).collect(Collectors.toList());

    private static final String UTF8 = "utf-8";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding(UTF8);
        // 验证token
        String token = request.getHeader("access_token");
        if(token != null) {
            boolean isToken = JwtUtil.verify(token);
            if(isToken) {
                return true;
            }
        }
        // 认证失败
        ResCode resCode = ResCode.AUTH_FAIL;
        ResultDto rdo = ResultDto.builder().code(resCode.getCode()).message(resCode.getMessage()).build();
        responseMessage(response, response.getWriter(), rdo);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 返回Error
     * @param response ..
     * @param out ..
     * @param rdo resultDto
     * */
    private void responseMessage(HttpServletResponse response, PrintWriter out, ResultDto rdo) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        out.print(JSONObject.toJSON(rdo));
        out.flush();
        out.close();
    }
}

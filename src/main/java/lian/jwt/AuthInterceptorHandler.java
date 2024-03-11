package lian.jwt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lian.jwt.*;

import io.jsonwebtoken.Claims;

/**
 * 自定义拦截器，主要用于用户鉴权
 *
 * @author AdminMall
 *
 */
public class AuthInterceptorHandler implements HandlerInterceptor {
    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private JwtKit jwtKit;

    /**
     * 前置拦截器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 获取到JWT的Token
        String jwtToken = request.getHeader(jwtProperties.getTokenHeader());
        if (jwtToken != null) {
            // 截取中间payload部分
            String payloadToken = jwtToken.substring(jwtProperties.getTokenHead().length());
            // 解析Token，获取Claims = Map
            Claims claims = jwtKit.parseJwtToken(payloadToken);
            // 获取payload中的报文，
            System.out.println("登陆人：" + claims.get("name").toString());

            return true;

        }

        System.out.println("登陆非法");
        return false;
    }
}

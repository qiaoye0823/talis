package com.example.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.Utils.JwtUtils;
import com.example.pojo.Result;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 获取请求url
        String url = req.getRequestURI().toString();
        log.info("请求的url:{}", url);

        if(url.contains("login")){
            log.info("登录操作，放行...");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 获取请求头中的令牌（token）
        String jwt = req.getHeader("token");

        // 判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        // 解析token
        try{
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}

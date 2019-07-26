package com.atguigu.gamll.interceptor;

import com.alibaba.fastjson.JSON;
import com.atguigu.gamll.annotation.LoginRequire;
import com.atguigu.gamll.constant.GamllConstant;
import com.atguigu.gamll.util.CookieUtil;
import com.atguigu.gamll.util.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Objects;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        LoginRequire loginRequire = handlerMethod.getMethodAnnotation(LoginRequire.class);
        if(loginRequire == null){
            //没有这个注解的方法直接放行
            return true;
        }

        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            token = CookieUtil.getCookieValue(request, GamllConstant.TOKEN_COOKIE_NAME, true);
        }

        if(StringUtils.isEmpty(token)){
            if(loginRequire.isNecessity()){//判断是否必须登录
                //没有token，跳转到登录页面
                response.sendRedirect("http://192.168.1.97:8086/index?returnUrl="+request.getRequestURL());
                return false;
            }
        } else {
            //有token,校验token的值
            String resultMapJson = HttpClientUtil.doGet("http://192.168.1.97:8086/verify?token="+token);
            HashMap<String,String> hashMap = JSON.parseObject(resultMapJson, new HashMap<String, String>().getClass());
            if(Objects.equals(hashMap.get("result"),"success")){
                CookieUtil.setCookie(request,response,GamllConstant.TOKEN_COOKIE_NAME,token,60*60*24*7,true);
                request.setAttribute("memberId",hashMap.get("memberId"));
                request.setAttribute("nickname",hashMap.get("nickname"));
            } else {
                if(loginRequire.isNecessity()) {//判断是否必须登录
                    response.sendRedirect("http://192.168.1.97:8086/index?returnUrl="+request.getRequestURL());
                    return false;
                }
            }
        }

        return true;
    }
}

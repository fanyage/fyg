package com.fh.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ZuulFilter extends com.netflix.zuul.ZuulFilter {
    @Value("${check.urls}")
    private String[] check_urls;

    @Override
    public String filterType() {
        //在路由之前执行
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        HttpServletResponse response = currentContext.getResponse();
        //处理跨域问题
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        //处理客户端传过来的自定义头信息
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "x-auth,userId,content-type");
        // 处理客户端发过来put,delete
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "PUT,POST,DELETE,GET");
        //获取请求方式
        String methodActoin = request.getMethod();
        if(methodActoin.equalsIgnoreCase("options")){
            // 禁止路由 不会继续向微服务发送请求
            currentContext.setSendZuulResponse(false);
            return null;
        }
        //获取请求路径
        String requestURI = request.getRequestURI();
        boolean isCheck=false;
        for (String check_url : check_urls) {
            //判断放开的是否有该请求
            if (check_url.contains(requestURI)){
                isCheck=true;
            }
        }
        if (isCheck){
            return null;
        }


        //判断用户是否登录
        return null;
    }

}

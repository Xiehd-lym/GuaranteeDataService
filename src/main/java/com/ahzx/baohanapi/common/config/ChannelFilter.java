package com.ahzx.baohanapi.common.config;

import cn.hutool.http.server.HttpServerRequest;
import com.ahzx.baohanapi.common.Interceptor.RequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
//import javax.xml.ws.RequestWrapper;
import java.io.IOException;

/**
 * @Author xiehd
 * @Date 2022 06 24
 **/
@WebFilter(urlPatterns = "*/",filterName = "channelFilter")
public class ChannelFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if (servletRequest instanceof HttpServerRequest)
            requestWrapper = new RequestWrapper((HttpServletRequest) servletRequest);
        if (requestWrapper == null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            filterChain.doFilter(requestWrapper,servletResponse);
        }
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}

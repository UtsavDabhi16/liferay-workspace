package com.liferay.hook;

import javax.servlet.*;
import java.io.IOException;


public class FilterHook implements Filter {

    @Override
    public void init(FilterConfig filterConfig)  {
        System.out.println("init ");
//        System.out.println("Called ServletFilter.init(" + filterConfig + ") where hello="
//                + filterConfig.getInitParameter("hello"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
        System.out.println("do filter ");

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

        System.out.println("destroy ");
    }
}

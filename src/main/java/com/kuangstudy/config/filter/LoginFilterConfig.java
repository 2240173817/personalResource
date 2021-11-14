package com.kuangstudy.config.filter;

import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Description:
 * Author: gaoshuai
 * Version: 1.0
 * Create Date Time: 2021/11/13 19:32.
 * Update Date Time:
 *
 * @see
 */
@WebFilter(filterName = "loginFilter",urlPatterns = {"/api/*","/index"})
public class LoginFilterConfig implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        Object quanxian = session.getAttribute("quanxian");
        System.out.println(quanxian);
        System.out.println("进来了");
        if (quanxian == null & quanxian != "lili"){
            resp.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }

}

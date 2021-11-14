package com.kuangstudy.controller;

import com.kuangstudy.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 飞哥
 * @Title: 学相伴出品
 * @Description: 飞哥B站地址：https://space.bilibili.com/490711252
 * 记得关注和三连哦！
 * @Description: 我们有一个学习网站：https://www.kuangstudy.com
 * @date 2021/11/12 22:56
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping("/loginlink")
    public String  loginLink(User user, HttpServletRequest request, Model model) {
        if (user.getPassword().equals("22")){
            request.getSession().setAttribute("quanxian","lili");
            ModelAndView mv = new ModelAndView();
            mv.addObject("ss", 200);
            mv.setViewName("index");
        }else
        System.out.println(user);

        return "index";
    }

}

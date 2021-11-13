package com.kuangstudy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuangstudy.entity.BlogCategory;
import com.kuangstudy.service.blogcategory.IBlogCategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: 首页controller
 * Author: yykk Administrator
 * Version: 1.0
 * Create Date Time: 2021/11/9 21:57.
 * Update Date Time:
 *
 * @see
 */
@Controller
@Log4j2
public class IndexController {

    @Autowired
    private IBlogCategoryService blogCategoryService;

    /**
     * Description: 首页
     * @throws Exception
     * @date 2021/11/9
     * @author yykk
     */
    @GetMapping(value = {"/", "/index"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        // 5: 把查询分类放入到数据模型中
        modelAndView.addObject("blogCategories", blogCategoryService.findBlogCategies());
        // 6: 跳转视图模板
        modelAndView.setViewName("index");
        return modelAndView;
    }


    /**
     * Description: 首页
     * @throws Exception
     * @date 2021/11/9
     * @author yykk
     */
    @GetMapping("/newsindex")
    public ModelAndView newindex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newsindex");
        return modelAndView;
    }


}

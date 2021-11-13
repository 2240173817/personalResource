package com.kuangstudy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kuangstudy.entity.Blog;
import com.kuangstudy.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 * Author: gaoshuai
 * Version: 1.0
 * Create Date Time: 2021/11/13 18:52.
 * Update Date Time:
 *
 * @see
 */
@RestController
public class Test {
    @Autowired
    public IBlogService iBlogService;

    @GetMapping("/pp")
    public Page<Blog> test(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                           @RequestParam(required = false,defaultValue = "3") Integer pageSize){
        Page page = new Page<>(pageNo,pageSize);
        LambdaQueryWrapper<Blog> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Blog::getCategoryId,1);
        Page page1 = iBlogService.page(page, lambdaQueryWrapper);
        return page1;
    }
}

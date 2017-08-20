package com.hwb.controller;

import com.hwb.bean.UserTest;
import com.hwb.service.UserTestService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by He on 2017/7/30.
 */

@Controller
public class UserTestController {

    private Logger log = Logger.getLogger(UserTestController.class);
    @Resource
    private UserTestService userTestService;

    private Configuration configuration = null; //解释Configuration

    @RequestMapping("/showAllUser")
    public String showUser(HttpServletRequest request, Model model){
        log.debug("查询所有用户信息");
        log.info("查询所有用户信息  info");
        System.out.println("查询所有用户信息   syso");
        List<UserTest> userList = userTestService.getAllUser();
        model.addAttribute("userList",userList);
        return "showAllUser";
    }

    @RequestMapping("/helloWorld")
    public String helloWorld(Model model) {
        String word0 = "Hello ";
        String word1 = "World!";
        //将数据添加到视图容器中
        log.debug("访问ftl页面");
        model.addAttribute("title","ftl模板页面");
        model.addAttribute("word0",word0);
        model.addAttribute("word1",word1);
        return "helloWorld";
    }

}

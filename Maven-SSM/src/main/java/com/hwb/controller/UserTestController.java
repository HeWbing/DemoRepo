package com.hwb.controller;

import com.hwb.bean.UserTest;
import com.hwb.service.UserTestService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by He on 2017/7/30.
 */

@Controller

public class UserTestController {

    private Logger log = Logger.getLogger(UserTestController.class);
    @Resource
    private UserTestService userTestService;

    @RequestMapping("/showAllUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        List<UserTest> userList = userTestService.getAllUser();
        model.addAttribute("userList",userList);
        return "showAllUser";
    }
}

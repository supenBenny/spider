package me.fb.spider.module.user.controller;

import me.fb.spider.module.user.domain.User;
import me.fb.spider.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/hello")
    @ResponseBody
    public String index() {
        return"Hello World";
    }


    @RequestMapping("/get")
    @ResponseBody
    public User get(Long id) {
        return userService.getNameById(id);
    }

}

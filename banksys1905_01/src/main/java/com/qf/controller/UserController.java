package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.entity.User;
import com.qf.service.UserService;
import com.qf.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login.do")
    public JsonResult login(String code, String password, HttpSession session) {

        try {
            User user = userService.login(code, password);
            session.setAttribute(StrUtils.LOGIN_INFO, user);
            return new JsonResult(0, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(1, e.getMessage());
        }
    }


    @RequestMapping("/balance.do")
    public JsonResult balance(HttpSession session) {

        User user = (User) session.getAttribute(StrUtils.LOGIN_INFO);
        if (user == null){
            return new JsonResult(1,"还未登录");
        }
        Double balance = userService.findBalance(user.getBankCode());

        return new JsonResult(0,balance);

    }


}

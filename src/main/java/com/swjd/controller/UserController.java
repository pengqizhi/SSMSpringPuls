package com.swjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swjd.bean.User;
import com.swjd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    //渠道登陆页面
    @RequestMapping("/toLogin1")
    public String toLogin(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "login";
    }

    //实现登录功能
    @RequestMapping("/doLogin1")
    public String doLogin(User user, Model model, HttpSession session){
        //调用service的 方法
        QueryWrapper<User> qw=new QueryWrapper<>();
        qw.eq("uname",user.getuName()).or().eq("password",user.getPassword());
        User u=userService.getOne(qw);
        if(u!=null){
            //账号密码正确
            if(u.getFlag().equals("1")){
                //可以登录成功的
                session.setAttribute("activeName",u.getuName());
                return "redirect:/toMain";
            }else {
                //账户被冻结
                model.addAttribute("errorMsg","账号被冻结，请联系客服");
                model.addAttribute("user",user);
                return "login";
            }
        }else {
            //账号密码不正确
            model.addAttribute("errorMsg","账号或者密码不正确");
            model.addAttribute("user",user);
            return "login";
        }
    }

    @RequestMapping("/toMain")
    public String toMain(){
        return "main";
    }
}

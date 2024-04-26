package com.example.takeaway.controller;

import com.example.takeaway.pojo.User;
import com.example.takeaway.service.RoleService;
import com.example.takeaway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class RouteController1 {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    //路由  路经映射页面
    @RequestMapping("/login")
    public String login(User loginuser, Model model, HttpSession session){
        User user = userService.login(loginuser.getUsercode(), loginuser.getPassword());//拿到输入的账号密码。
        if (user!=null){
            session.setAttribute("user",user);
            Map<Integer, String> roleMap = roleService.getAllRole();
            session.setAttribute("roles",roleMap);
            return "redirect:/toindex";
        }//如果验证通过，重定向到/toindex路径
        else {
            model.addAttribute("msg","账号或密码输入有误");//错误提示错误信息
            return "login";
        }
    }
    @RequestMapping("/toindex")
    public String toindex(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        Integer rid = user.getRid();
        return "index";
    }//获取用户id之后跳转到登录首页面
    @RequestMapping("/toPositionManager")
    public String toPersonalSet(){
        return "position_manager";
    }
    @RequestMapping("/toPWSet")
    public String toPWSet(){
        return "pw_set";
    }
}

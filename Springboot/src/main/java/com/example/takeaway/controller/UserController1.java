package com.example.takeaway.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.takeaway.pojo.User;
import com.example.takeaway.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController1 {

    @Autowired
    private UserService userService;

    //    @Autowired
//    private RoleService roleService;
//负责处理用户相关的HTTP请求
    @RequestMapping("/toUserManager")
    public String toUserManager(Model model){
        List<User> allUser = userService.getAll();
        model.addAttribute("allUser",allUser);
        return "user_manager";
    }//处理请求 "/user/toUserManager"，负责跳转到用户管理页面（user_manager.html），并将所有用户信息传递给该页面。
    @RequestMapping("/toSetUser/{uid}")
    public String toUserSet(@PathVariable("uid") Integer uid,Model model){
        User userinfo = userService.getById(uid);
        model.addAttribute("userinfo",userinfo);
        return "user_set";
    }//处理请求 "/user/toSetUser/{uid}"，根据用户ID（uid）查询用户信息，然后跳转到用户设置页面（user_set.html），将用户信息传递给该页面。
    @RequestMapping("/toAddUser")
    public String toUserAdd(){
        return "user_add";
    }
    //处理请求 "/user/toAddUser"，负责跳转到添加用户页面（user_add.html）。
    @RequestMapping("/search")
    public String search(@RequestParam("usercode")String usercode,@RequestParam("position")String position,Model model){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        if (usercode!=null&&!usercode.equals("")) {
            queryWrapper.like("usercode",usercode);
        }
        if (position!=null&&!position.equals("")) {
            queryWrapper.like("position",position);
        }
        queryWrapper.ne("rid",1);
        List<User> list = userService.list(queryWrapper);
        model.addAttribute("allUser",list);
        return "user_manager";
    }//处理请求 "/user/search"，根据用户输入的用户编码（usercode）和真实姓名（realname）进行模糊查询，然后将查询结果返回给用户管理页面。
    @RequestMapping("/userAdd")
    public String userAdd(User user,Model model){
        boolean b = userService.save(user);
        return "redirect:/user/toUserManager";
    }
    //处理请求 "/user/userAdd"，用于添加用户。接收用户信息，调用 userService.save(user) 将用户信息保存到数据库，然后重定向到用户管理页面。
    @RequestMapping("/userSet")
    public String userSet(User user,Model model){
        log.info("成功到了userSet" + user);
        userService.updateById(user);
        System.out.println("成功调用了update");
        System.out.println(user);
        return "redirect:/user/toUserManager";
    }//处理请求 "/user/userSet"，用于修改用户信息。接收修改后的用户信息，调用 userService.updateById(user) 更新用户信息，然后重定向到用户管理页面。
    @RequestMapping("/userDel/{uid}")
    public String userDel(@PathVariable("uid") Integer uid,Model model){
        boolean b = userService.removeById(uid);
        return "redirect:/user/toUserManager";
    }//处理请求 "/user/userDel/{uid}"，用于删除用户。根据用户ID（uid），调用 userService.removeById(uid) 删除用户信息，然后重定向到用户管理页面。


































    

}

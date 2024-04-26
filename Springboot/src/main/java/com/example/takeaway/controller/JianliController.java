package com.example.takeaway.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.takeaway.pojo.Jianli;
import com.example.takeaway.service.JianliService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequestMapping("/jianli")
@Controller //标识为返回类型为Json的控制
public class JianliController {
    @Autowired
    private JianliService jianliService;
    //标识请求地址
    @RequestMapping("/toJianliManager")
    public String toJianliManager(Model model){
        List<Jianli> allJianli = jianliService.selectJianliList();
        model.addAttribute("allJianli",allJianli);
        return "jianli_manager";
    }
    @RequestMapping("/toJianliManager1")
    public String toJianliManager1(Model model){
        List<Jianli> allJianli = jianliService.selectJianliList();
        model.addAttribute("allJianli",allJianli);
        return "jianli_manager1";
    }
    //标识请求地址
    @RequestMapping("/toAddJianli")
    public String insertJianli(Jianli jianli){

        return "jianli_add";
    }
    @RequestMapping("/jianliAdd")
    public String jianliAdd(Jianli jianli){
        log.info("赵笑梦nb" + jianli);
        jianliService.insertJianli(jianli);

        return "redirect:/jianli/toJianliManager";
    }
    @RequestMapping("/toSetJianli/{id}")
    public String toJianliSet(@PathVariable("id") Integer id,Model model)
    {
        Jianli jianliinfo = jianliService.getById(id);
        model.addAttribute("jianliinfo",jianliinfo);
        return "jianli_set";
    }

    @RequestMapping("/toSetJianli1/{rname}")
    public String toJianliSet1(@PathVariable("rname") String rname,Model model)
    {
        Jianli jianliinfo = jianliService.getByRname(rname);
        model.addAttribute("jianliinfo",jianliinfo);
        return "jianli_set";
    }
    //标识请求地址
    @RequestMapping("/updateJianli")
    public String jianliSet(Jianli jianli){
        log.info("成功到了jianliSet" + jianli);
        jianliService.updateJianli(jianli);
//        System.out.println("成功调用了update");
        System.out.println(jianli);
        return "redirect:/jianli/toJianliManager";
    }//处理请求 "/user/userSet"，用于修改用户信息。接收修改后的用户信息，调用 userService.updateById(user) 更新用户信息，然后重定向到用户管理页面。

    //    //标识请求地址
    @RequestMapping("/deleteJianli/{id}")
    public String jianliDel(@PathVariable("id") String rname, Model model){
        int b = jianliService.deleteJianli(rname);
        return "redirect:/jianli/toJianliManager";
    }//处理请求 "/user/userDel/{uid}"，用于删除用户。根据用户ID（uid），调用 userService.removeById(uid) 删除用户信息，然后重定向到用户管理页面。
    //

    @RequestMapping("/JianliSelect")
    public String JianliSelect(@RequestParam("position")String position, Model model){
        QueryWrapper<Jianli> queryWrapper=new QueryWrapper<>();
        if (position!=null&&!position.equals("")) {
            queryWrapper.like("position",position);
        }
//        queryWrapper.ne("id",1);
        List<Jianli> list = jianliService.list(position);
        model.addAttribute("allJianli",list);
        return "jianli_manager";
    }//处理请求 "/user/search"，根据用户输入的用户编码（usercode）和真实姓名（realname）进行模糊查询，然后将查询结果返回给用户管理页面。

}

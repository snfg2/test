package com.example.takeaway.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.takeaway.pojo.Position;
import com.example.takeaway.pojo.User;
import com.example.takeaway.service.IPositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequestMapping("/position")
@Controller //标识为返回类型为Json的控制
public class PositionController {
    @Autowired
    private IPositionService ipositionService;
    //标识请求地址
    @RequestMapping("/toPositionManager")
    public String toPositionManager(Model model){
        List<Position> allPosition = ipositionService.selectPositionList();
        model.addAttribute("allPosition",allPosition);
        return "position_manager";
    }
    @RequestMapping("/toPositionManager1")
    public String toPositionManager1(Model model){
        List<Position> allPosition = ipositionService.selectPositionList();
        model.addAttribute("allPosition",allPosition);
        return "position_manager1";
    }
    //标识请求地址
    @RequestMapping("/toAddPosition")
    public String insertPosition(Position position){

        return "position_add";
    }
    @RequestMapping("/positionAdd")
    public String positionAdd(Position position){
        log.info("赵笑梦nb" + position);
        ipositionService.insertPosition(position);

        return "redirect:/position/toPositionManager";
    }
    @RequestMapping("/toSetPosition/{id}")
    public String toPositionSet(@PathVariable("id") Integer id,Model model)
    {
        Position positioninfo = ipositionService.getById(id);
        model.addAttribute("positioninfo",positioninfo);
        return "position_set";
    }
    //标识请求地址
    @RequestMapping("/updatePosition")
    public String positionSet(Position position){
        log.info("成功到了positionSet" + position);
        ipositionService.updatePosition(position);
//        System.out.println("成功调用了update");
        System.out.println(position);
        return "redirect:/position/toPositionManager";
    }//处理请求 "/user/userSet"，用于修改用户信息。接收修改后的用户信息，调用 userService.updateById(user) 更新用户信息，然后重定向到用户管理页面。

//    //标识请求地址
    @RequestMapping("/deletePosition/{id}")
    public String positionDel(@PathVariable("id") String gs, Model model){
        int b = ipositionService.deletePositionByGongsi(gs);
        return "redirect:/position/toPositionManager";
    }//处理请求 "/user/userDel/{uid}"，用于删除用户。根据用户ID（uid），调用 userService.removeById(uid) 删除用户信息，然后重定向到用户管理页面。
//
    @RequestMapping("/PositionSelect")

    public String PositionSelect(@RequestParam("xzy")String xzy, Model model){
        QueryWrapper<Position> queryWrapper=new QueryWrapper<>();
        if (xzy!=null&&!xzy.equals("")) {
            queryWrapper.like("xzy",xzy);
        }
//        queryWrapper.ne("id",1);
        List<Position> list = ipositionService.list(xzy);
        model.addAttribute("allPosition",list);
        return "position_manager";
    }//处理请求 "/user/search"，根据用户输入的用户编码（usercode）和真实姓名（realname）进行模糊查询，然后将查询结果返回给用户管理页面。

}

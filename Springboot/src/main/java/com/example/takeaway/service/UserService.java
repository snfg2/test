package com.example.takeaway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.takeaway.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
    //UserService接口继承了IService<User>，表示它是一个服务接口，提供了对User实体的通用服务方法。
//该接口提供了对用户信息的通用服务，例如用户登录和获取所有用户等
    public User login(String usercode,String password);

    public List<User> getAll();

}

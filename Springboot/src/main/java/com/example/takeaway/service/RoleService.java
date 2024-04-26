package com.example.takeaway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.takeaway.pojo.Role;
import java.util.Map;
//RoleService接口
//该接口提供了对角色信息的通用服务，例如获取所有角色
public interface RoleService extends IService<Role> {//RoleService接口继承了IService<Role>
    Map<Integer, String> getAllRole();
//该方法的目的是获取所有角色的信息并以 Map 的形式返回

}

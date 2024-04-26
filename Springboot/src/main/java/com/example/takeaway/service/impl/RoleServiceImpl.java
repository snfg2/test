package com.example.takeaway.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeaway.dao.RoleDao;
import com.example.takeaway.pojo.Role;
import com.example.takeaway.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
//@Service 注解标识了这是一个 Spring 的服务层组件
public class RoleServiceImpl  extends ServiceImpl<RoleDao, Role> implements RoleService {
//实现roleservice接口
    @Autowired
    RoleDao roleDao;//通过 Spring 的依赖注入，将 RoleDao 注入到该类中。
    @Override
    public Map<Integer, String> getAllRole() {
        //创建查询条件封装条件
        QueryWrapper roleWapper=new QueryWrapper();
        //添加条件，排除管理员
        roleWapper.ne("rname","管理员");
        //从数据库中查询角色列表
        List<Role> list = roleDao.selectList(roleWapper);
        Map<Integer, String> maps = list.stream().collect(Collectors.toMap(Role::getRid, Role::getRname, (key1, key2) -> key2));//使用 Java 8 Stream API 将角色列表转换为 Map，以角色的 ID 为键，角色名称为值。
        return maps;//将角色列表转换为Map的目的通常是为了更方便地使用和检索角色信息。在这里，以角色ID为键，角色名称为值构建了一个Map，这样可以通过角色ID快速获取对应的角色名称。
    }
}

package com.example.takeaway.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeaway.pojo.Role;
import com.example.takeaway.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper// MyBatis Plus 提供的注解 @Mapper用于与 MyBatis 集成
@Repository//Spring 的 @Repository 注解的 RoleDao 接口。
public interface RoleDao extends BaseMapper<Role> {//这是 MyBatis Plus 提供的通用 Mapper 接口，通过继承它，
    // RoleDao 就拥有了一系列基础的数据库操作方法，无需手动编写 SQL 语句，简化了数据访问层的开发。
    @Select("select * from User where usercode=#{usercode} or password=#{password}")
    public User login(String usercode, String password);
    public Map<Integer, String> getAllRole();
}


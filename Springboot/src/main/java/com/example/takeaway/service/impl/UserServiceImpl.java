package com.example.takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeaway.dao.UserDao;
import com.example.takeaway.pojo.User;
import com.example.takeaway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User login(String usercode, String password) {
        QueryWrapper userWapper =new QueryWrapper();
        userWapper.eq("usercode",usercode);
        userWapper.eq("password",password);//通过QueryWrapper创建查询条件
        User user = userDao.selectOne(userWapper);
        return user;
    }
    @Override
    public List<User> getAll() {
        QueryWrapper userWapper =new QueryWrapper();
        userWapper.ne("rid",1);
        List<User> list = userDao.selectList(userWapper);//设置条件为"rid"不等于1，表示排除管理员用户。
        // 然后调用userDao.selectList查询数据库，返回符合条件的用户列表。
        return list;
    }




}

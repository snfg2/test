package com.example.takeaway.dao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeaway.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {
    @Select("select * form User")
    public List<User> getAll();
    @Update("UPDATE User set usercode=#{usercode}, realname=#{realname}, emile=#{emile}, phone=#{phone},qq=#{qq}, adress=#{adress}, position=#{position}, professional=#{professional}, rid=#{rid}  where uid=#{uid}")
    public int updateById(User user);
    @Delete("DELETE FROM User WHERE uid=#{uid}")
    public User removeById(Integer uid);
    @Insert("INSERT INTO User(usercode,realname,emile,phone ,qq,adress,position,professinal,rid)"+"values (#{usercode},#{realname},#{emile},#{phone} ,#{qq},#{adress},#{position},#{professinal},#{rid})")
    public boolean save(User user);
}


package com.example.takeaway.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.takeaway.pojo.Jianli;
import com.example.takeaway.pojo.Position;
import com.example.takeaway.pojo.User;

import java.util.List;


public interface JianliService
{
    public Jianli selectJianliByrname(String rname);

    public List<Jianli> selectJianliList();


    public  int insertJianli(Jianli jianli);

    public int updateJianli(Jianli jianli);



    public int deleteJianli(String jianli);


    List<Jianli> list(String position);

    Jianli getById(Integer id);
    Jianli getByRname(String rname);
}

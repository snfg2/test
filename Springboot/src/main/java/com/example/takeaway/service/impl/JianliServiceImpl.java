package com.example.takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.takeaway.dao.JianliDao;
import com.example.takeaway.dao.PositionDao;
import com.example.takeaway.pojo.Jianli;
import com.example.takeaway.pojo.Position;
import com.example.takeaway.pojo.User;
import com.example.takeaway.service.IPositionService;
import com.example.takeaway.service.JianliService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class JianliServiceImpl implements JianliService
{
    @Autowired
    private JianliDao jianliDao;

    @Override
    public Jianli selectJianliByrname(String rname) {
        return null;
    }



    @Override
    public List<Jianli> selectJianliList()    {
        return jianliDao.selectJianliList();
    }


    @Override
    public int insertJianli(Jianli jianli)
    {
        log.info("大梦" + jianli);
        return jianliDao.insertJianli(jianli);
    }


    @Override
    public int updateJianli(Jianli jianli)
    {
        return jianliDao.updateJianli(jianli);
    }


    @Override
    public int deleteJianli(String rname)
    {
        return jianliDao.deleteJianli(rname);
    }


    @Override
    public List<Jianli> list(String position) {
        return jianliDao.listByposition(position);
    }

    @Override
    public Jianli getById(Integer id)
    {
        return jianliDao.getById(id);
    }
    public Jianli getByRname(String rname)
    {
        return jianliDao.getByRname(rname);
    }
}
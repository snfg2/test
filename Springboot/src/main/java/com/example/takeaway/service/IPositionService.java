package com.example.takeaway.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.takeaway.pojo.Position;
import com.example.takeaway.pojo.User;

import java.util.List;


public interface IPositionService
{
    public Position selectPositionByGongsi(String gs);

    public List<Position> selectPositionList();

    public  int insertPosition(Position position);


    public int updatePosition(Position position);



    public int deletePositionByGongsi(String gs);


    List<Position> list(String xzy);

    Position getById(Integer id);
}

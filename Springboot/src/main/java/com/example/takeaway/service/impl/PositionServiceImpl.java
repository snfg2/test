package com.example.takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.takeaway.dao.PositionDao;
import com.example.takeaway.pojo.Position;
import com.example.takeaway.pojo.User;
import com.example.takeaway.service.IPositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PositionServiceImpl implements IPositionService
{
    @Autowired
    private PositionDao positionDao;

    /**
     * @param gs
     * @return
     */
    @Override
    public Position selectPositionByGongsi(String gs) {
        return null;
    }

    //    @Override
//    public Position selectPositionByGongsi(String gs)
//    {
//        Position position;
//        List<Position> list=positionDao.selectPositionList(position);
//        return positionDao.selectPositionByGongsi(gs);
//    }


    @Override
    public List<Position> selectPositionList()    {
        return positionDao.selectPositionList();
    }

    /**
     * 新增positon管理
     *
     * @param position positon管理
     * @return 结果
     */
    @Override
    public int insertPosition(Position position)
    {
        log.info("大梦" + position);
        return positionDao.insertPosition(position);
    }

    /**
     * 修改positon管理
     *
     * @param position positon管理
     * @return 结果
     */
    @Override
    public int updatePosition(Position position)
    {
        return positionDao.updatePosition(position);
    }


    @Override
    public int deletePositionByGongsi(String gs)
    {
        return positionDao.deletePositionByGs(gs);
    }


    @Override
    public List<Position> list(String xzy) {
        return positionDao.listByxzy(xzy);
    }
     @Override
    public Position getById(Integer id)
    {
        return positionDao.getById(id);
    }
}
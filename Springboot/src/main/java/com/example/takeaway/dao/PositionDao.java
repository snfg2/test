package com.example.takeaway.dao;


import com.example.takeaway.pojo.Position;
import com.example.takeaway.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface PositionDao
{

    public Position selectPositionByGongsi(String gs);

    @Select("select * from position where xzy = #{xzy}")
    public List<Position> listByxzy(String xzy);

    @Select("select * from position")
    public List<Position> selectPositionList();

    /**
     * 新增positon管理
     *
     * @param position positon管理
     * @return 结果
     */
    @Insert("insert into `position`(`gs`, `gang`, `gongzi`, `xzy`) values(#{gs}, #{gang},#{gongzi},#{xzy})")
    public int insertPosition(Position position);

    /**
     * 修改positon管理
     *
     * @param position positon管理
     * @return 结果
     */
    @Update("UPDATE position set gs=#{gs}, gang=#{gang}, gongzi=#{gongzi},xzy=#{xzy} where id=#{id}")
    public int updatePosition(Position position);
    @Delete("DELETE FROM position WHERE id=#{id}")
    public int deletePositionByGs(String gs);
    @Select("select * from position where id=#{id}")
    public Position getById(Integer id);



}

package com.example.takeaway.dao;


import com.example.takeaway.pojo.Jianli;
import com.example.takeaway.pojo.Position;
import com.example.takeaway.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface JianliDao
{

    public Position selectPositionByGongsi(String gs);

    @Select("select * from jianli where position = #{position}")
    public List<Jianli> listByposition(String position);

    @Select("select * from jianli")
    public List<Jianli> selectJianliList();

    @Insert("insert into `jianli`(`rname`, `age`, `sex`, `major`,`award`,`position`) values(#{rname}, #{age},#{sex},#{major},#{award},#{position})")
    public int insertJianli(Jianli jianli);
    @Update("UPDATE jianli set rname=#{rname}, age=#{age}, sex=#{sex},major=#{major},award=#{award},position=#{position} where id=#{id}")
    public int updateJianli(Jianli jianli);
    @Delete("DELETE FROM jianli WHERE id=#{id}")
    public int deleteJianli(String rname);
    @Select("select * from jianli where id=#{id}")
    public Jianli getById(Integer id);


    @Select("select * from jianli where rname=#{rname}")
    public Jianli getByRname(String rname);



}

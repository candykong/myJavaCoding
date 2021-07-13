package com.iflybank.demo.dao;

import com.iflybank.demo.model.Userinfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserinfoMapper {
    @Delete({
            "delete from userinfo",
            "where id = #{id,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte id);

    @Insert({
            "insert into userinfo (id, age, ",
            "info, name)",
            "values (#{id,jdbcType=TINYINT}, #{age,jdbcType=INTEGER}, ",
            "#{info,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Userinfo record);

    @Select({
            "select",
            "id, age, info, name",
            "from userinfo",
            "where id = #{id,jdbcType=TINYINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.TINYINT, id=true),
            @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
            @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Userinfo selectByPrimaryKey(Byte id);

    @Update({
            "update userinfo",
            "set age = #{age,jdbcType=INTEGER},",
            "info = #{info,jdbcType=VARCHAR},",
            "name = #{name,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(Userinfo record);
}

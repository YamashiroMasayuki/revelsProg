package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Insert("insert into users (name) values (#{name})")
    public boolean create(String name);

    @Select("select * from users")
    public List<User> read();

    @Update("update users set name = #{name} where id = #{id}")
    public boolean update(int id, String name);

    @Delete("delete from users where id = #{id}")
    public boolean delete(int id);

}
package com.fz.mapper;

import com.fz.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by bai on 2017/6/19.
 */
public interface StudentMapper {
    //注解添加数据
    @Insert("insert into student values(null,#{name},#{score},#{address})")
    public int insert(Map<String,Object> map);
    //使用映射配置文件添加数据
    public int add(Map<String,Object> map);
    //调用存储过程添加数据
    public int calladd(Map<String,Object> map);
    //调用存储过程删除数据
    public int del(int id);
    //使用注解删除指定数据
    @Delete("delete from student where id = #{id}")
    public int delBy(int id);
    //使用映射配置文件删除指定数据
    public int dele(int id);
    //使用注解修改数据
    @Update("update student set s_name=#{name},s_score=#{score},s_address=#{address} where id = #{id}")
    public int up(Student student);
    //使用映射配置文件修改数据
    public int change(Map<String,Object> map);
    //调用存储过程修改数据
    public int updat(Map<String,Object> map);
    //使用注解查询数据
    @Select("select * from student where 1=1") @ResultMap("sk")
    public List<Student> query();
    //调用存储过程查询数据
    public List<Student> quname(String name);
    //使用配置文件查询数据
    public List<Student> quer();

}

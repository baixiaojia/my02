package com;

import com.fz.entity.Student;
import com.fz.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by bai on 2017/6/19.
 */
public class Demo {
    private SqlSessionFactory sf;
    private SqlSession session;
    private StudentMapper stu;
    @Before
    public void a() throws IOException {
        sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        session = sf.openSession(true);
        stu=session.getMapper(StudentMapper.class);
    }
    @After
    public void aa(){
        session.commit();
        session.close();
    }

    @Test
    public void insert(){
        //使用注解添加数据
        /*
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","大家");
        map.put("score",60);
        map.put("address","上海市");
        int i = stu.insert(map);
        System.out.println(i+"   使用注解添加数据");
        */

        //使用配置文件添加数据
      /*
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","看破");
        map.put("score",100);
        map.put("address","云南省");
        int i = stu.add(map);
        System.out.println(i+"   使用映射配置文件添加数据");
        */

        //调用存储过程添加数据
       /*
        Map<String,Object>map = new HashMap<String,Object>();
        map.put("name","打开了");
        map.put("score",30d);
        map.put("address","进度加快");
        int i = stu.calladd(map);
        System.out.println(i+"   调用存储过程添加数据");
        */

        //调用存储过程删除指定数据
        /*
       int i = stu.del(25);
        System.out.println(i + "    调用存储过程删除指定数据");
        */
        //使用注解删除指定数据
        /*
         int i = stu.delBy(24);
        System.out.println(i+"  使用注解删除指定数据");
        */
        //使用映射配置文件删除指定数据
        /*
        int i = stu.dele(23);
        System.out.println(i +"  使用映射配置文件删除指定数据");
        */
        //使用注解修改数据（此种方法效率低 适合多项修改）
        /*
        Student s = new Student();
        s.setName("李四");
        s.setId(1);
        int i = stu.up(s);
        System.out.println(i+"  使用注解修改数据");
       */
        //使用映射配置文件修改数据
        /*
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",1);
        map.put("name","李思思");
        map.put("score",100);
        map.put("address","内蒙古");
        int i = stu.change(map);
        System.out.println(i + "   使用映射配置文件修改数据");
       */
        //调用存储过程修改数据
        /*
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","Tom");
        map.put("did",17);
        int i = stu.updat(map);
        System.out.println(i+"   调用存储过程修改数据");
       */
        //使用注解查询数据  (注意查询结果表的字段名要映射到实体类的相对应的属性)
        /*
        List<Student> list = stu.query();
        for(Student s : list){
            System.out.println(s.getName());
        }
        System.out.println("------------使用注解查询数据");
        */
        //调用存储过程查询数据
        /*
        List<Student> list = stu.quname("jack");
        for(Student s : list){
            System.out.println(s.getName());
            System.out.println(s.getScore());
            System.out.println(s.getAddress());
        }
        System.out.println("------------调用存储过程查询数据");
        */
        //使用配置文件查询数据
        /*
        List<Student> list = stu.quer();
        for(Student s : list){
            System.out.println(s.getName());
        }
        System.out.println("-------使用配置文件查询数据");
        */
        //使用动态sql语句查询数据
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","Tom");
       // map.put("score",11);
        //map.put("address","北京市都是");

        map.put("id",new int[]{1,13,15,17});
        List<Student> list = stu.querd(map);
        for(Student s:list){
            System.out.println(s.getName()+"     " +  s.getScore()+"    "+s.getAddress()+"   "+s.getId());
        }



        //使用动态sql语句修改数据
        /*
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","决定分开");
        map.put("id",22);
        int i = stu.upd(map);
        System.out.println(i+"   使用动态sql语句修改数据");
        */


    }
}

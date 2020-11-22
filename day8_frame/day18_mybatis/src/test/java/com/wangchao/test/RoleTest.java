package com.wangchao.test;

import com.wangchao.bean.QueryVo;
import com.wangchao.bean.Role;
import com.wangchao.bean.User;
import com.wangchao.dao.RoleDao;
import com.wangchao.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//测试信息
public class RoleTest {
    /*经研究发现，其中的代码可以复用，提取出来*/
    //加载配置文件
    InputStream is ;
    SqlSession sqlSession;
    //获取代理对象
    RoleDao roleDao;
    //在执行其他方法之前先执行吃方法，加了注解@Before
    @Before
    public void init() throws IOException {
        is= Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //将配置文件加载进来
        SqlSessionFactory sessionFactory = builder.build(is);
        //此处设置为true,则直接就提交了事务
        sqlSession = sessionFactory.openSession(true);
        //获取代理对象
        roleDao = sqlSession.getMapper(RoleDao.class);
    }
    @After
    public void destory() throws IOException {
        //提交事务  在进行添加、删除、修改操作时
       // sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAllRole(){
        List<Role> list = roleDao.findAllRole();
        for (Role role:list) {
            System.out.println(role);

        }
    }
    @Test
    public void testFindAllUser(){
        List<User> list = roleDao.findAllUser();
        for (User user:list) {
            System.out.println(user);
        }
    }
}

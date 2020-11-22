package com.wangchao.test;

import com.wangchao.bean.QueryVo;
import com.wangchao.bean.User;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//测试信息
public class UserAssTest {
    /*经研究发现，其中的代码可以复用，提取出来*/
    //加载配置文件
    InputStream is ;
    SqlSession sqlSession;
    //获取代理对象
    UserDao userdao;
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
        userdao = sqlSession.getMapper(UserDao.class);
    }
    @After
    public void destory() throws IOException {
        //提交事务  在进行添加、删除、修改操作时
       // sqlSession.commit();
        sqlSession.close();
        is.close();
    }
    //测试注解
    @Test
    public void testfindAllUser(){
        List<User> list = userdao.findAllUser();
        for (User user:list) {
            System.out.println(user);
        }
    }

    //测试注解
    @Test
    public void testfindById(){
        User user = userdao.findById(10);
            System.out.println(user);
    }

    //测试注解
    @Test
    public void testsaveUserAss(){
        User user = new User();
        user.setUsername("貂蝉");
        user.setSex("女");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.format(date);
        user.setBirthday(date);
        user.setAddress("海淀区中关村88号");
        userdao.saveUserAss(user);
        System.out.println(user);
    }

    @Test
    public void testupdateUserAss(){
        User user = new User();
        user.setId(9);
        user.setUsername("聂清");
        user.setAddress("青城山下八宝洞中");
        int i = userdao.updateUserAss(user);
        System.out.println(i);
    }
    @Test
    public void testdeleteUserAss(){
        int i = userdao.deleteUserAss(7);
        System.out.println(i);
    }

    
    @Test
    public void testfindTotalAss(){
        int i = userdao.findTotalAss();
        System.out.println(i);
    }


    @Test
    public void testfindUserByNameAss(){
        List<User> list = userdao.findUserByNameAss("%姬%");
        for (User user: list){
            System.out.println(user);
        }
    }
}

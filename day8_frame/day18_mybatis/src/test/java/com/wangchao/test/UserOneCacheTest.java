package com.wangchao.test;

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

public class UserOneCacheTest {
    //测试一级缓存
    InputStream is;
    SqlSessionFactory factory;
    @Before
    public void init() throws IOException {
         //加载配置文件
         is = Resources.getResourceAsStream("SqlMapConfig.xml");
         //获取SqlSessionFactory对象
         factory = new SqlSessionFactoryBuilder().build(is);
    }

    @After
    public void destory() throws IOException {
        is.close();
    }

    //测试一级缓存
    @Test
    public void testOneCache(){
        SqlSession sqlSession1 = factory.openSession();
        UserDao userDao = sqlSession1.getMapper(UserDao.class);
        //查询用户信息
        User user = userDao.selectUserById(10);
        System.out.println("user : "+user);
        //清空以及缓存
        sqlSession1.close();//一级缓存消失

        SqlSession sqlSession2 = factory.openSession();
        UserDao userdao = sqlSession2.getMapper(UserDao.class);
        User user2 = userdao.selectUserById(10);
        System.out.println("user2 : "+user2);
        sqlSession2.close();

        System.out.println(user==user2);
    }
}

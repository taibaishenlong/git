package com.wangchao.test;

import com.wangchao.bean.User;
import com.wangchao.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//批量插入用户信息
public class UserBatchProc {
    @Test
    public void testBatch() throws IOException {
        //1.加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSession对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.开启session
        SqlSession sqlSession = sessionFactory.openSession(ExecutorType.BATCH);
        //4.创建list集合 ，将内容添加进入
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setUsername("东风");
        User user1 = new User();
        user1.setUsername("天龙");
        User user2 = new User();
        user2.setUsername("凤凰");
        list.add(user);
        list.add(user2);
        list.add(user1);
        //获取调用的方法
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        for (User user4:list) {
            userDao.insertValues(user4);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}

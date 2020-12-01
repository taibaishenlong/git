package com.wangchao.test;


import com.wangchao.bean.User;
import com.wangchao.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//测试类
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream is = MybatisTest.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory的构建者对象
        SqlSessionFactoryBuilder sqlBuilder = new SqlSessionFactoryBuilder();
//       //使用构建者对象创建工厂对象
        SqlSessionFactory factory = sqlBuilder.build(is);
        //使用factory生产session对象
        SqlSession sqlSession = factory.openSession();
        //使用session创建dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //使用代理对象执行查询所有方法
        List<User> users = userDao.findUserById();
        for (User user:users) {
            System.out.println(user);
        }
        /*//基于注解形式的查询操作
        User user = userDao.findUserById(2);
        System.out.println(user);*/
        //释放资源
        sqlSession.close();
        is.close();
    }
}

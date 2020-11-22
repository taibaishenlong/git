package com.wangchao.test;

import com.wangchao.bean.Account;
import com.wangchao.bean.AccountUser;
import com.wangchao.bean.User;
import com.wangchao.dao.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccoutDaoTest {
    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private AccountDao accountDao;
    @Before
    public void init() throws IOException {
        //1.加载配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(is);
        sqlSession = factory.openSession(true);
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void destory() throws IOException {
        is.close();
        sqlSession.close();
    }
    @Test
    public void testFindAll(){
        List<AccountUser> list = accountDao.findAll();
        for (AccountUser accountUser:list) {
            System.out.println(accountUser);
        }
    }

    //一对一查询
    @Test
    public void testFindAllAcc(){
      /* // List<Account> list = accountDao.findAllAcc();
        for (Account account:list) {
            System.out.println(account);
        }*/
    }
    //一对多查询
    @Test
    public void testFindAllUser(){
        List<User> allUser = accountDao.findAllUser();
        for (User user:allUser) {
            System.out.println(user);
        }
    }
    
    @Test
    public void testFindLazy(){
        List<Account> allLazy = accountDao.findAllLazy();
        for (Account account:allLazy) {
            System.out.println(account);
        }
    }

    //测试账户的一对一关联寄延迟加载
    @Test
    public void testOneToOne(){
        List<Account> list = accountDao.findAllAccountAndUser();
        for (Account account :list) {
            System.out.println(account+account.getUser().getUsername());
        }
    }
}

package com.wangchao.day1019.jdbc;


import com.wangchao.day1019.jdbc.bean.Account;
import com.wangchao.day1019.jdbc.dao.AccountDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class JDBCTest {
    @Test
    public void testExtend(){
        //准备数据源：spring的内置数据源
        DriverManagerDataSource da = new DriverManagerDataSource();
        da.setDriverClassName("com.mysql.cj.jdbc.Driver");
        da.setUrl("jdbc:mysql://localhost:3306/javaweb?serverTimezone=GMT%2B8");
        da.setUsername("root");
        da.setPassword("root");
        //创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(da);
        //执行添加操作
        jdbcTemplate.execute("insert into account(name,balance) values('lucy',8888)");
    }

    @Test
    public void testxml(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springjdbc.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        //保存操作
        //jdbcTemplate.execute("insert into account(name,balance) values('jim',9999)");
        //更新操作
        //jdbcTemplate.update("update account set name=?,balance=? where id = ?","coco",8976,4);
        //删除操作
        //jdbcTemplate.update("delete from account where id = ? ",4);
        //查询所有
        /*List<Account> list = jdbcTemplate.query("select * from account where balance > ?", new BeanPropertyRowMapper<>(Account.class), 1000f);
        for (Account account:list) {
            System.out.println("account :"+account);
        }*/
        //查询一个
        /*List<Account> list = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), 6);
        System.out.println(list.get(0));*/
        //查询返回一行
        Long count = jdbcTemplate.queryForObject("select count(*) from account where balance > ?", Long.class, 1000f);
        System.out.println(count);
    }

    @Test
    public void testxmlSuper(){
        //获取容器
        ApplicationContext context = new ClassPathXmlApplicationContext("springjdbc.xml");
        //获取accountDao对象
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        //执行方法
        Account account = accountDao.findAccountById(2);
        System.out.println("account : "+account);
    }

    @Test
    public void testxmlJDBCTemplate(){
        //获取容器
        ApplicationContext context = new ClassPathXmlApplicationContext("springjdbc.xml");
        //获取accountDao对象
        AccountDao accountDao = (AccountDao) context.getBean("accountDao2");
        //执行方法
        Account account = accountDao.findAccountById(2);
        System.out.println("account : "+account);
    }
}

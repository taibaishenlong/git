package com.wangchao.test;

import com.wangchao.dao.AccountDao;
import com.wangchao.factory.BeanFactory;
import com.wangchao.service.AccountService;
import com.wangchao.service.AccountService0;
import com.wangchao.service.AccountService2;
import com.wangchao.service.AccountService3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    @Test
    public void testProperties(){
        for(int i=0;i<6;i++){
            AccountService0 bean = (AccountService0) BeanFactory.getBean("accountServcie");
            System.out.println(bean);
            bean.saveAccount();
        }
    }
    @Test
    public void testBeanXml(){
        /* 加载配置文件 */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //通过配置文件获取beans.xml中的id
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        System.out.println(accountService);
        AccountDao accountDao = (AccountDao)applicationContext.getBean("accountDao");
        System.out.println(accountDao);
    }
    //测试构造函数依赖注入
    @Test
    public void testBeanXmlCons(){
        /* 加载配置文件 */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //通过配置文件获取beans.xml中的id
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        //调用方法
        accountService.saveAccount();//张三 : 18 : Mon Aug 31 16:53:46 CST 2020     保存了账户
        System.out.println(accountService);//com.wangchao.service.impl.AccountServiceImpl@5b1669c0
    }
    //测试set方法依赖注入
    @Test
    public void testSet(){
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
         AccountService2 accountService2 = (AccountService2)applicationContext.getBean("accountService2");
         //调用方法
        accountService2.saveAccount();//李白 : 24 : Mon Aug 31 17:13:20 CST 2020
    }
    //测试set方法依赖注入复杂数据
    @Test
    public void testSetFu(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        AccountService3 accountService3 = (AccountService3)applicationContext.getBean("accountService3");
        //调用方法
        accountService3.saveAccount();//
    }
}

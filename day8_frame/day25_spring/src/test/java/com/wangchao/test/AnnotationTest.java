package com.wangchao.test;


import com.wangchao.dao.AccountDao;
import com.wangchao.service.AccountService;
import com.wangchao.service.AccountService4;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    //测试spring的注解形式
    @Test
    public void testAnno(){
        //读取配置文件anno.xml
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("anno.xml");
         //通过读取的配置文件获取对象
        AccountService4 accountService4 = (AccountService4) applicationContext.getBean("accountService4");
//        System.out.println("accountService4 : "+accountService4);
        AccountDao accountDao = applicationContext.getBean("accountDao1", AccountDao.class);
        System.out.println("accountDao : "+accountDao);
//         accountService4.saveAccount();
    }
    //测试scope  多例和单例
    @Test
    public void testSing(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("anno.xml");
        AccountService4 accountService4 = applicationContext.getBean("accountService4", AccountService4.class);
        AccountService4 accountService41 = applicationContext.getBean("accountService4", AccountService4.class);
        System.out.println(accountService4==accountService41);//当设置范围scope=prototype时，结果为false,如果范围为scope=singleton时，结果为true
    }

    //测试声明周期的方法
    @Test
    public void testInit_destory(){
        //加载配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("anno.xml");
        AccountService4 accountService4 = context.getBean("accountService4", AccountService4.class);
        accountService4.saveAccount();
        //关闭资源
        context.close();
    }
}

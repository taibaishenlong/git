package com.wangchao.day0928;

import com.wangchao.day0928.config.SpringConfiguration;
import com.wangchao.day0928.domain.Account;
import com.wangchao.day0928.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestSpring {
    @Test
    public void testwithoutxml(){
        ApplicationContext anno = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = anno.getBean("accountService", AccountService.class);
        List<Account> list = accountService.findAll();
        for (Account account:list) {
            System.out.println(account);
        }
    }
}

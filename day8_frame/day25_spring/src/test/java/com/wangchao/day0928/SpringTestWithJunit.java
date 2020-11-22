package com.wangchao.day0928;

import com.wangchao.day0928.config.SpringConfiguration;
import com.wangchao.day0928.domain.Account;
import com.wangchao.day0928.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
spring整合junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringTestWithJunit {
    @Autowired
    public AccountService as ;

    @Test
    public void testSpringWithClass(){
        List<Account> list = as.findAll();
        for (Account account:list) {
            System.out.println(account);
        }
    }
}

package com.wangchao.day0928;

import com.wangchao.day0804.domain.Account;
import com.wangchao.day0804.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
spring整合junit  通过xml
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:iocbeananno.xml")
public class SpringTestWithJunit2 {
    @Autowired
    private AccountService accountService ;

    @Test
    public void testSpringWithClass(){
        List<Account> list = accountService.findAll();
        for (Account account:list) {
            System.out.println(account);
        }
    }
}

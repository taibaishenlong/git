package com.wangchao.day1021.threetx_iso_withoutxml.test;

import com.wangchao.day1021.threetx_iso_withoutxml.config.SpringConfigurtaion;
import com.wangchao.day1021.threetx_iso_withoutxml.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//测试类
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfigurtaion.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService ias;

    @Test
    public void testTransfer(){
        ias.transfer("jim","lucy",1000f);
    }
}

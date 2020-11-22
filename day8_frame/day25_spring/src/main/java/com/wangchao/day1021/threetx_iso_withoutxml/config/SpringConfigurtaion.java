package com.wangchao.day1021.threetx_iso_withoutxml.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//spring的配置类，相当于bean.xml
@Configuration
@ComponentScan("com.wangchao.day1021.threetx_iso_withoutxml")
@PropertySource(value = "21jdbcconfig.properties")
@Import({JdbcConfig.class,TransactionConfig.class})
@EnableTransactionManagement
public class SpringConfigurtaion {
}

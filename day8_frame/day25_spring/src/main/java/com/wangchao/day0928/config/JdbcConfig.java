package com.wangchao.day0928.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

//连接数据库的配置
//@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private  String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean("runner")
    public QueryRunner createQueryRunner(@Qualifier("datasource") ComboPooledDataSource dataSource){
        return new QueryRunner(dataSource);
    }
    //创建数据源
    @Bean("datasource")
    public ComboPooledDataSource createDataSource(){
        try{
            ComboPooledDataSource ds = new ComboPooledDataSource();
            System.out.println("driver:"+driver);
            System.out.println("url:"+url);
            System.out.println("user:"+username);
            System.out.println("password:"+password);
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}

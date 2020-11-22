package com.wangchao.day0928.config;

import org.springframework.context.annotation.*;

/*
使用该类代替xml文件，其中有些新的注解
 */
@ComponentScan("com.wangchao.day0928")
@Import(JdbcConfig.class)
@Configuration
public class SpringConfiguration {
    /*@Bean("runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }
    @Bean("dataSource")
    public DataSource createDatasource(){
        try{
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/javaweb?serverTimezone=GMT%2B8");
            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            ds.setUser("root");
            ds.setPassword("root");
            return  ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }*/

}

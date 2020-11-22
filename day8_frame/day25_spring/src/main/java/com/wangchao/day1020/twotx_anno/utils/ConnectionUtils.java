package com.wangchao.day1020.twotx_anno.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接工具类，它用于从数据源中获取一个连接，并实现和线程的绑定
 */
@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> t1 = new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        //1.先充ThreadLocal上获取
        Connection conn = t1.get();
        try {
            //2.判断当前线程上是否有连接、
            if(conn == null){
                //3.从数据源中获取一个连接，并且存入到ThreadLocal中
                conn = dataSource.getConnection();
                t1.set(conn);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //4.返回当前线程上的连接
        return conn;
    }
    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        t1.remove();
    }

}


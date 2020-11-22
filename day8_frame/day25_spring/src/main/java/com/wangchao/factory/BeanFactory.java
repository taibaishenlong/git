package com.wangchao.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//定义一个工厂类  用于存储数据内容
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;

    //定义一个Map,用于存放我们要创建的对象。我们把它称之为容器
    private static Map<String,Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("beans.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出配置文件中所有的Key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个Key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                System.out.println(key+" : "+value);
                //把key和value存入容器中
                beans.put(key,value);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    /*private static Properties pros;
    //创建一个map,用于存放数据
    private static Map<String,Object> map ;
    static {
        try {
            //加载配置文件
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("beans.properties");
            //创建properties对象
            pros = new Properties();
            pros.load(is);
            //然后遍历文件
            Enumeration<Object> keys = pros.keys();
            map  = new HashMap<String,Object>();
            while(keys.hasMoreElements()){
                //获取键
                String key  =  keys.nextElement().toString();
                String beanPath = pros.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                System.out.println(key+" : "+value);
                //将数据放入到map中
                map.put(key,value);
            }
        } catch (Exception  e) {
           throw new ExceptionInInitializerError("初始化properties失败");
        }
    }
    public static  Object getBean(String beanName){
        return map.get(beanName);
    }*/
   /* //根据名称获取bean对象
    public  static Object getBean(String beanName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object bean ;
        String beanPath = pros.getProperty(beanName);
        //根据路径反射获取对象
        bean = Class.forName(beanPath).newInstance();
        return   bean;
    }*/
}

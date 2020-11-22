package com.wangchao.test;

import com.wangchao.bean.QueryVo;
import com.wangchao.bean.User;
import com.wangchao.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//测试信息
public class UserTest {
    /*经研究发现，其中的代码可以复用，提取出来*/
    //加载配置文件
    InputStream is ;
    SqlSession sqlSession;
    //获取代理对象
    UserDao userdao;
    //在执行其他方法之前先执行吃方法，加了注解@Before
    @Before
    public void init() throws IOException {
        is= Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //将配置文件加载进来
        SqlSessionFactory sessionFactory = builder.build(is);
        //此处设置为true,则直接就提交了事务
        sqlSession = sessionFactory.openSession(true);
        //获取代理对象
        userdao = sqlSession.getMapper(UserDao.class);
    }
    @After
    public void destory() throws IOException {
        //提交事务  在进行添加、删除、修改操作时
       // sqlSession.commit();
        sqlSession.close();
        is.close();
    }
    //查询的方法
    @Test
    public void testFindAll() throws IOException {
        //调用方法
        List<User> list = userdao.findAll();
        //遍历
        for (User user:list) {
            System.out.println(user);
        }
    }
    //向数据库中添加一条数据
    @Test
    public void testSaveUser(){
        //先创建一个用户对象
        User user = new User();
        user.setUsername("杨玉环");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("大唐皇宫尚书房");
        //调用userDao中的保存方法
        userdao.saveUser(user);
    }
    //删除一条数据
    @Test
    public void testDeleteUserById(){
        userdao.deleteUserById(2);
    }
    //测试修改数据信息
    @Test
    public void testUpdateUserById(){
        //创建一个user对象
        User user = new User();
        user.setUsername("姬发");
        user.setAddress("商朝皇宫");
        user.setBirthday(new Date());
        user.setId(6);
        userdao.updateUserById(user);
    }
    //根据用户id 查询用户信息
    @Test
    public void testSelectUserById(){
        User user = userdao.selectUserById(5);
        System.out.println("user  : "+user);
    }
    //模糊查询
    @Test
    public void testSelectUserLike(){
       /* List<User> list = userdao.findUserLike("%姬%");*/
        List<User> list = userdao.findUserLike("姬");
        for (User user1:list) {
            System.out.println(user1);
        }
    }
    //查询总 记录数
    @Test
    public void testCountUser(){
        int i = userdao.countUser();
        System.out.println("总记录数是 ："+i);
    }
    //根据queryvo中的条件进行查询操作
    @Test
    public void testQueryVo(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%姬%");
        queryVo.setUser(user);
        List<User> qv = userdao.findUserByQv(queryVo);
        for (User users:qv) {
            System.out.println("users : "+users);

        }
    }

    /*sql if语句测试*/
    @Test
    public void testfindbyUser(){
        User user = new User();
        user.setUsername("%姬%");
        user.setAddress("%号%");
        List<User> list = userdao.findByUser(user);
        for (User userL:list) {
            System.out.println(userL);
        }
    }

    @Test
    public void testFindIds(){
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(6);
        list.add(11);
        vo.setList(list);
        List<User> inIds = userdao.findInIds(vo);
        for (User user:inIds) {
            System.out.println(user);
        }
    }

    /*证明mybatis一级缓存的存着  */
    @Test
    public void testCache(){
        //查询两次  如果只发出一次sql语句 则证明缓存是存在的
        User user = userdao.selectUserById(10);
        System.out.println("user :  "+user);
        User user1 = userdao.selectUserById(10);
        System.out.println("user1 :  "+user1);
        System.out.println(user.equals(user1));
    }
    //  清空一级缓存
    @Test
    public void testFirstLevelCache(){
        User user = userdao.selectUserById(10);
        System.out.println(user);
        //清空缓存
        sqlSession.clearCache();
        User user1 = userdao.selectUserById(10);
        System.out.println(user1);
        System.out.println(user==user1);
    }
    //测试缓存的同步
    @Test
    public void testCleareCache(){
        //1.根据id查询用户
        User user = userdao.selectUserById(10);
        System.out.println("user : " +user);
        //更新用户信息
        user.setUsername("李寻欢");
        user.setAddress("洛阳龙门石窟88号");
        userdao.findByUser(user);
        ///再次查询id为10的用户
        User user2 = userdao.selectUserById(10);
        System.out.println("user2 : "+user2);
        System.out.println(user==user2);
    }
}

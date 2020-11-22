package com.wangchao.dao;

import com.wangchao.bean.QueryVo;
import com.wangchao.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    //查询所有
    List<User> findAll();
    //保存用户信息
    void saveUser(User user);
    //根据id删除一条信息
    void deleteUserById(Integer  id);
    //根据id修改数据
    void updateUserById(User user);
    //根据id查询用户
    @Select("select * from user where id = #{id}")
    @ResultMap("userMapAll")
    User selectUserById(Integer id);
    //模糊查询信息
    List<User> findUserLike(String username);
    //查询总记录数
    int countUser();
    //根据queryVo查询用户信息
    List<User> findUserByQv(QueryVo vo);

    //动态sql  根据用户信息 查询用户列表
    List<User> findByUser(User user);

    //根据id集合查询用户
    List<User> findInIds(QueryVo vo);

    //使用注解方式实现开发
    @Select("select * from user")
    @Results(id="userMapAll",
              value={
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "address",property = "address"),
            @Result(column = "birthday",property = "birthday"),
    })
    List<User> findAllUser();

    //根据id查询一个用户
    @Select("select * from user where id = #{uid}")
    @ResultMap("userMapAll")
    User findById(Integer userid);


    //保存操作
    @Insert("insert into user(username,sex,birthday,address) values(#{username},#{sex},#{birthday},#{address})")
    @SelectKey(keyColumn = "id" ,keyProperty = "uid",resultType = Integer.class,before=false,statement = {"select last_insert_id()"})
    int saveUserAss(User user);

    //更新操作
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    int updateUserAss(User user);

    //删除用户
    @Delete("delete from user where id=#{id}")
    int deleteUserAss(Integer uid);

    //查询使用聚合函数
    @Select("select count(*) from user")
    int findTotalAss();

    //模糊查询
    @Select("select * from user where username like #{username}")
    List<User> findUserByNameAss(String name);

    /*批处理插入*/
    @Insert("insert into user(username) values(#{username})")
    void insertValues(User user);
}

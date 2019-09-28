package com.xiaolai.ssm.dao;

import com.xiaolai.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 14:17
 **/
public interface UserDao {

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class,
                    many = @Many(select = "com.xiaolai.ssm.dao.RoleDao.findByNotUserId"))})
    public UserInfo findById(String id) throws Exception;

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class,
                    many = @Many(select = "com.xiaolai.ssm.dao.RoleDao.findByUserId"))})
    public UserInfo findByUserName(String username) throws Exception;

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    @Insert("insert into users (id,email,password,username,phoneNum,status) values " +
            "(#{id},#{email},#{password},#{username},#{phoneNum},#{status})")
    void saveUser(UserInfo user) throws Exception;


    @Insert("insert into users_role (userId,roleId) values (#{userId},#{id})")
    void addRole(@Param("userId") String userId, @Param("id") String id) throws Exception;
}

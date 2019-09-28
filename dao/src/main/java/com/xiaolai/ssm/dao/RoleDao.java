package com.xiaolai.ssm.dao;

import com.xiaolai.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 14:30
 **/
public interface RoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId=#{userId}) ")
    List<Role> findByUserId(String userId) throws Exception;

    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId}) ")
    List<Role> findByNotUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll();

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions", column = "id" ,javaType = List.class,
                many = @Many(select = "com.xiaolai.ssm.dao.PermissionDao.findByRoleId")
            )
    })
    Role findById(String id);

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions", column = "id" ,javaType = List.class,
                    many = @Many(select = "com.xiaolai.ssm.dao.PermissionDao.findByNotRoleId")
            )
    })
    Role findByIdNotPermission(String id);

    @Delete("delete from users_role where roleId=#{roleId}")
    void deleteFromUser_RoleByRoleId(String roleId);

    @Delete("delete from role_permission where roleId=#{roleId}")
    void deleteFromRole_PermissionByRoleId(String roleId);

    @Delete("delete from role where id=#{roleId}")
    void deleteRoleById(String roleId);

    @Insert("insert into role (id,roleName,roleDesc) values (#{id},#{roleName},#{roleDesc})")
    void addRole(Role role);


    @Insert("insert into role_permission (roleId,permissionId) values (#{roleId},#{id})")
    void addPermissionById(@Param("roleId") String roleId, @Param("id") String id);

    @Select("select * from role where id in (select roleId from role_permission where permissionId=#{id})")
    List<Role> findByPermissionId(@Param("id") String id);
}

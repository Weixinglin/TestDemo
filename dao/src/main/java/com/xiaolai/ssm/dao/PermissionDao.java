package com.xiaolai.ssm.dao;

import com.xiaolai.ssm.domain.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 16:36
 **/
@Repository
public interface PermissionDao {


    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findByRoleId(@Param("id") String id);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findByNotRoleId(@Param("id") String id);

    @Select("select * from permission where id=#{id}")
    @Results({
            @Result(id = true,property = "id", column = "id"),
            @Result(property = "permissionName",column = "permissionName"),
            @Result(property = "url",column = "url"),
            @Result(property = "roles",column = "id" ,javaType = List.class,
                many = @Many(select = "com.xiaolai.ssm.dao.RoleDao.findByPermissionId")
            )
    })
    Permission findById(String id);

    @Delete("delete from role_permission where permissionId=#{permissionId}")
    void deletePermissionIdFromRolePermission(String permissionId);

    @Delete("delete from permission where id=#{id}")
    void deleteById(String id);

    @Insert("insert into permission (id,permissionName,url) values (#{id},#{permissionName},#{url})")
    void addPermission(Permission permission);
}

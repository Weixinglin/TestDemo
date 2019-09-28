package com.xiaolai.ssm.service;

import com.xiaolai.ssm.domain.Role;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 16:43
 **/
public interface RoleService {
    List<Role> findAll();

    Role findById( String id);

    void deleteRoleById(String id);

    void addRole(Role role);

    Role findByIdNot(String id);

    void addPermission(String roleId, String[] ids);
}

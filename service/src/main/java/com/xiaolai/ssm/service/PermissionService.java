package com.xiaolai.ssm.service;

import com.xiaolai.ssm.domain.Permission;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 16:35
 **/
public interface PermissionService {
    List<Permission> findAll() throws Exception;

    Permission findById(String id);

    void deletePermissionById(String id);

    void addPermission(Permission permission);
}

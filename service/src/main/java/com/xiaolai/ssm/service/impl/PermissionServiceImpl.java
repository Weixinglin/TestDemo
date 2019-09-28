package com.xiaolai.ssm.service.impl;

import com.xiaolai.ssm.dao.PermissionDao;
import com.xiaolai.ssm.domain.Permission;
import com.xiaolai.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 16:35
 **/
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public Permission findById(String id) {
        return permissionDao.findById(id);
    }

    @Override
    public void deletePermissionById(String id) {

        permissionDao.deletePermissionIdFromRolePermission(id);

        permissionDao.deleteById(id);
    }

    @Override
    public void addPermission(Permission permission) {
        permissionDao.addPermission(permission);
    }
}

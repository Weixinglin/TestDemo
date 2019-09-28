package com.xiaolai.ssm.service.impl;

import com.xiaolai.ssm.dao.RoleDao;
import com.xiaolai.ssm.domain.Role;
import com.xiaolai.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author weixinglin
 * @Date 2019/9/3 16:43
 **/
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void deleteRoleById(String id) {
        roleDao.deleteFromRole_PermissionByRoleId(id);
        roleDao.deleteFromUser_RoleByRoleId(id);
        roleDao.deleteRoleById(id);
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role findByIdNot(String id) {
        return roleDao.findByIdNotPermission(id);
    }

    @Override
    public void addPermission(String roleId, String[] ids) {
        for(String id : ids){
            roleDao.addPermissionById(roleId,id);
        }
    }
}

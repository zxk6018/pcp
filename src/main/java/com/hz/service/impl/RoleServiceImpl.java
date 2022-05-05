package com.hz.service.impl;

import com.hz.dao.RoleDao;
import com.hz.pojo.Role;
import com.hz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    public RoleDao roleDao;

    @Override
    public List<Role> findRoleList(Integer page, Integer pageSize, String roleName, String roleTime)
    {
        Integer pyl = (page-1)*pageSize;
        return roleDao.findRoleList(pyl,pageSize,roleName,roleTime);
    }

    @Override
    public Integer updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public Integer roleCount(String roleName, String roleTime) {
        return roleDao.roleCount(roleName,roleTime);
    }

    @Override
    public Integer deleteRoleById(Integer roleId) {
        return roleDao.deleteRoleById(roleId);
    }

    @Override
    public Role findRoleById(Integer roleId) {
        return roleDao.findRoleById(roleId);
    }

    @Override
    public Integer seeRole(Role role) {
        return roleDao.seeRole(role);
    }

    @Override
    public Integer saveRole(Role role) {
        return roleDao.saveRole(role);
    }
}

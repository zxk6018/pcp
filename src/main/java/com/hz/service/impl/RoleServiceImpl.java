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

    /**
     * 多条件 分页查询
     * @param page
     * @param pageSize 每页显示数量
     * @param roleName
     * @param roleTime
     * @return
     */
    @Override
    public List<Role> findRoleList(Integer page, Integer pageSize, String roleName, String roleTime)
    {
        Integer pyl = (page-1)*pageSize;
        return roleDao.findRoleList(pyl,pageSize,roleName,roleTime);
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @Override
    public Integer updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    /**
     * 总记录数
     * @param roleName
     * @param roleTime
     * @return
     */
    @Override
    public Integer roleCount(String roleName, String roleTime) {
        return roleDao.roleCount(roleName,roleTime);
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @Override
    public Integer deleteRoleById(Integer roleId) {
        return roleDao.deleteRoleById(roleId);
    }

    /**
     * 根据ID 查询角色
     * @param roleId
     * @return
     */
    @Override
    public Role findRoleById(Integer roleId) {
        return roleDao.findRoleById(roleId);
    }

    /**
     * 查看角色详情
     * @param role
     * @return
     */
    @Override
    public Integer seeRole(Role role) {
        return roleDao.seeRole(role);
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @Override
    public Integer saveRole(Role role) {
        return roleDao.saveRole(role);
    }
}

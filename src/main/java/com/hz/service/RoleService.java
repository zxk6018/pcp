package com.hz.service;

import com.hz.pojo.Role;

import java.util.List;

public interface RoleService {
    /**
     * 查询角色
     * @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @return
     */
    List<Role> findRoleList(Integer pyl,
                            Integer pageSize,
                            String roleName,
                            String roleTime);


    /**
     * 修改角色
     * @param role
     * @return
     */
    Integer updateRole(Role role);


    /**
     * 总记录数
     * @return
     */
    Integer roleCount(String roleName,String roleTime);


    /**
     * 删除角色
     * @param roleId
     * @return
     */

    Integer deleteRoleById(Integer roleId);


    /**
     * 新增角色
     * @param role
     * @return
     */
    Integer saveRole(Role role);

    /**
     * 根据ID  获得角色对象
     * @param roleId
     * @return
     */
    Role findRoleById(Integer roleId);

    /**
     * 查看角色具体信息
     * @param role
     * @return
     */
    Integer seeRole(Role role);

}

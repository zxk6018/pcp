package com.hz.service;

import com.hz.pojo.Role;

import java.util.List;

public interface RoleService {
    /**
     * 查询用户
     * @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @return
     */
    List<Role> findRoleList(Integer pyl,
                            Integer pageSize,
                            String roleName,
                            String roleTime);



    /*
    * 修改用户
     * @param user
     * @return
    * */
    Integer updateRole(Role role);


    /**
     * 总记录数
     * @return
     */
    Integer roleCount(String roleName,String roleTime);


    /*
     *删除用户
     * @param userId
     * @return
     * */

    Integer deleteRoleById(Integer roleId);


    /*
     * 新增用户
     *
     * */
    Integer saveRole(Role role);

    /**
     * 根据ID  获得用户对象
     * @param roleId
     * @return
     */
    Role findRoleById(Integer roleId);

    /**
     * 查看管理员具体信息
     * @param role
     * @return
     */
    Integer seeRole(Role role);

}

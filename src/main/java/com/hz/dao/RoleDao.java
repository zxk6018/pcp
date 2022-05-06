package com.hz.dao;


import com.hz.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    /*
    * 查询
    *  @param pyl 偏移量
    * @param pageSize 每页显示数量
    * @return
    * */
    List<Role> findRoleList(@Param("pyl") Integer pyl,
                            @Param("pageSize") Integer pageSize,
                            @Param("roleName") String roleName,
                            @Param("roleTime") String roleTime
                            );


    /**
     * 修改角色
     * @param role
     * @return
     */
    Integer updateRole(Role role);

    /**
     * 总记录数
     * @param roleName
     * @param roleTime
     * @return
     */
    Integer roleCount(@Param("roleName") String roleName,
                      @Param("roleTime") String roleTime
                      );


    /*
    * 删除角色
    * @param roleID
    * @return
    * */
    Integer deleteRoleById(Integer roleId);


    /**
     * 新增角色
     * @param role
     * @return
     */
    Integer saveRole(Role role);

    /**
     * 根据ID  获得角色
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



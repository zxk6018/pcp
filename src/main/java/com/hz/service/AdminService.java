package com.hz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService extends IService<Admin> {



    /**
     * 删除管理员
     * @param adminId
     * @return
     */
    Integer deleteAdminById(Integer adminId);
    /**
     * 修改管理员
     * @param admin
     * @return
     */

    Integer updateAdmin(Admin admin);
    /**
     * 新增管理员
     * @param admin
     * @return
     */
    Integer saveAdmin(Admin admin);

    /**
     * 查询管理员
     * @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @return
     */

    List<Admin> findAdminList(@Param("pyl") Integer pyl,
                              @Param("pageSize") Integer pageSize,
                              @Param("adminName") String adminName,
                              @Param("adminPhone") String adminPhone
    );

    /**
     * 总记录数
     * @return
     */
    Integer AdminCount(String adminName, String adminPhone);

    /**
     * 根据ID  获得管理员对象
     * @param id
     * @return
     */
    Admin findAdminById(Integer id);

    /**
     * 查看管理员具体信息
     * @param admin
     * @return
     */
    Integer seeAdmin(Admin admin);

}

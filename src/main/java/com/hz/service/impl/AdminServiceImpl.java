package com.hz.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.dao.AdminDao;
import com.hz.pojo.Admin;
import com.hz.service.AdminService;
import com.hz.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl  implements AdminService {

    @Autowired
    private AdminDao adminDao;



    /**
     * 根据ID删除管理员
     * @param adminId
     * @return
     */
    @Override
    public Integer deleteAdminById(Integer adminId) {
        return adminDao.deleteAdminById(adminId);
    }

    /**
     * 根据ID修改管理员
     * @param admin
     * @return
     */
    @Override
    public Integer updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @Override
    public Integer saveAdmin(Admin admin) {
        return adminDao.saveAdmin(admin);
    }

    /**
     * 查询管理员
     * @param pageNo
     * @param pageSize
     * @param adminName
     * @param adminPhone
     * @return
     */
    @Override
    public List<Admin> findAdminList(Integer pageNo, Integer pageSize, String adminName,String adminPhone) {
        Integer pyl = (pageNo-1)*pageSize;
        return adminDao.findAdminList(pyl,pageSize,adminName,adminPhone);
    }

    /**
     * 获取总数据数
     * @param adminName
     * @param adminPhone
     * @return
     */
    @Override
    public Integer AdminCount(String adminName,String adminPhone) {
        return adminDao.AdminCount(adminName,adminPhone);
    }

    /**
     * 根据ID查找管理员
     * @param adminId
     * @return
     */
    @Override
    public Admin findAdminById(Integer adminId) {
        return adminDao.findAdminById(adminId);
    }

    /**
     * 查看管理员具体信息
     * @param admin
     * @return
     */
    @Override
    public Integer seeAdmin(Admin admin) {
        return adminDao.seeAdmin(admin);
    }

}

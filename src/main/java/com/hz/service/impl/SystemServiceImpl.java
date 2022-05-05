package com.hz.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.dao.SystemDao;
import com.hz.pojo.System;
import com.hz.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/4 14:45
 * @Version 1.5
 */
@Service
public class SystemServiceImpl extends ServiceImpl<BaseMapper<System>,System> implements SystemService {

    @Autowired
    private SystemDao systemDao;

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize 每页显示数量
     * @param systemId
     * @param systemName
     * @return
     */
    //通过权限名和父级ID查询
    @Override
    public List<System> findSystemList(Integer pageNo, Integer pageSize, String systemId, String systemName) {
        Integer pyl = (pageNo-1)*pageSize;
        return systemDao.findSystemList(pyl,pageSize,systemId,systemName);
    }

    @Override
    public Integer SystemCount(String systemId, String systemName) {
        return systemDao.SystemCount(systemId,systemName);
    }

    @Override
    public System findSystemById(Integer systemId) {
        return systemDao.findSystemById(systemId);
    }

    /**
     * 新增权限
     * @param system
     * @return
     */
    @Override
    public Integer saveSystem(System system) {
        return systemDao.saveSystem(system);
    }

    /**
     * 删除权限
     * @param systemId
     * @return
     */
    @Override
    public Integer deleteSystemById(Integer systemId) {
        return systemDao.deleteSystemById(systemId);
    }
}

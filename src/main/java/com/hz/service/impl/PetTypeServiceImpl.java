package com.hz.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.dao.PetTypeDao;
import com.hz.pojo.Pettype;
import com.hz.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/5 14:06
 * @Version 1.5
 */
@Service
public class PetTypeServiceImpl extends ServiceImpl<BaseMapper<Pettype>,Pettype> implements PetTypeService {

    @Autowired
    private PetTypeDao petTypeDao;

    /**
     * 分页
     * @param pageNo
     * @param pageSize 每页显示数量
     * @param pettypeId 宠物类型ID
     * @param pettypeName   宠物类型名称
     * @return
     */
    @Override
    public List<Pettype> findPettypeList(Integer pageNo, Integer pageSize, String pettypeId, String pettypeName) {
        Integer pyl = (pageNo-1)*pageSize;
        return petTypeDao.findPettypeList(pyl,pageSize,pettypeId,pettypeName);
    }

    /**
     * 获取总条数
     * @param pettypeId
     * @param pettypeName
     * @return
     */
    @Override
    public Integer PettypeCount(String pettypeId, String pettypeName) {
        return petTypeDao.PettypeCount(pettypeId,pettypeName);
    }

    /**
     * 根据ID查找宠物类型
     * @param pettypeId
     * @return
     */
    @Override
    public Pettype findPettypeById(Integer pettypeId) {
        return petTypeDao.findPettypeById(pettypeId);
    }

    /**
     * 新增宠物类型
     * @param pettype
     * @return
     */
    @Override
    public Integer savePettype(Pettype pettype) {
        return petTypeDao.savePettype(pettype);
    }

    /**
     * 删除宠物类型
     * @param pettypeId
     * @return
     */
    @Override
    public Integer deletePettypeById(Integer pettypeId) {
        return petTypeDao.deletePettypeById(pettypeId);
    }
}

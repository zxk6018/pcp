package com.hz.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.dao.PetCircleDao;
import com.hz.pojo.Petcircle;
import com.hz.service.PetCircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/6 11:17
 * @Version 1.5
 */
@Service
public class PetCircleServiceImpl extends ServiceImpl<BaseMapper<Petcircle>,Petcircle> implements PetCircleService {

    @Autowired
    private PetCircleDao petCircleDao;

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize 每页显示数量
     * @param petcircleId 文章ID
     * @param petcircleUserId 用户ID
     * @return
     */
    @Override
    public List<Petcircle> findPetcircleList(Integer pageNo, Integer pageSize, String petcircleId, String petcircleUserId) {
        Integer pyl = (pageNo-1)*pageSize;
        return petCircleDao.findPetcircleList(pyl,pageSize,petcircleId,petcircleUserId);
    }

    /**
     * 获取数据总条数
     * @param petcircleId
     * @param petcircleUserId
     * @return
     */
    @Override
    public Integer PetcircleCount(String petcircleId, String petcircleUserId) {
        return petCircleDao.PetcircleCount(petcircleId,petcircleUserId);
    }

    /**
     * 根据ID查找文章
     * @param petcircleId
     * @return
     */
    @Override
    public Petcircle findPetcircleById(Integer petcircleId) {
        return petCircleDao.findPetcircleById(petcircleId);
    }

    /**
     * 新增文章
     * @param petcircle
     * @return
     */
    @Override
    public Integer savePetcircle(Petcircle petcircle) {
        return petCircleDao.savePetcircle(petcircle);
    }

    /**
     * 删除文章
     * @param petcircleId
     * @return
     */
    @Override
    public Integer deletePetcircleById(Integer petcircleId) {
        return petCircleDao.deletePetcircleById(petcircleId);
    }

    /**
     * 查看文章详情
     * @param petcircle
     * @return
     */
    @Override
    public Integer seePetcircle(Petcircle petcircle) {
        return petCircleDao.seePetcircle(petcircle);
    }
}
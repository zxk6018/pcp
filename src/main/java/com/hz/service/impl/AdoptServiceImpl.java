package com.hz.service.impl;

import com.hz.dao.AdoptDao;
import com.hz.pojo.Adopt;
import com.hz.service.AdoptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdoptServiceImpl implements AdoptService {

    @Autowired
    private AdoptDao adoptDao;

    /**
     * 多条件 分页查询
     * @param page
     * @param pageSize
     * @param adoptType
     * @param adoptTime
     * @return
     */
    @Override
    public List<Adopt> findAdoptList(Integer page, Integer pageSize, String adoptType, String adoptTime) {
        Integer pyl = (page-1)*pageSize;
        return adoptDao.findAdoptList(pyl,pageSize,adoptType,adoptTime);
    }

    /**
     * 总记录数
     * @param adoptType
     * @param adoptTime
     * @return
     */
    @Override
    public Integer AdoptCount(String adoptType, String adoptTime) {
        return adoptDao.AdoptCount(adoptType,adoptTime);
    }

    /**
     * 新增发布领养与寄养信息
     * @param adopt
     * @return
     */
    @Override
    public Integer saveAdopt(Adopt adopt) {
        return adoptDao.saveAdopt(adopt);
    }

    /**
     * 修改发布领养与寄养信息
     * @param adopt
     * @return
     */
    @Override
    public Integer updateAdopt(Adopt adopt) {
        return adoptDao.updateAdopt(adopt);
    }

    /**
     * 删除发布领养与寄养信息
     * @param adoptId
     * @return
     */
    @Override
    public Integer deleteAdoptById(Integer adoptId) {
        return adoptDao.deleteAdoptById(adoptId);
    }

    /**
     * 查看发布领养与寄养信息详情
     * @param adopt
     * @return
     */
    @Override
    public Integer seeAdopt(Adopt adopt) {
        return adoptDao.seeAdopt(adopt);
    }

    /**
     * 根据ID  获得发布领养与寄养信息
     * @param adoptId
     * @return
     */
    @Override
    public Adopt findAdoptById(Integer adoptId) {
        return adoptDao.findAdoptById(adoptId);
    }


}

package com.hz.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.dao.PetHelpDao;
import com.hz.pojo.Pethelp;
import com.hz.service.PethelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/3 21:14
 * @Version 1.5
 */

@Service
public class PethelpServiceImpl extends ServiceImpl<BaseMapper<Pethelp>,Pethelp> implements PethelpService {

    @Autowired
    private PetHelpDao petHelpDao;

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize 每页显示数量
     * @param pethelpName 救助队队名
     * @param pethelpUserPhone 救助队电话
     * @return
     */
    @Override
    public List<Pethelp> findPethelpList(Integer pageNo, Integer pageSize, String pethelpName, String pethelpUserPhone) {
        Integer pyl = (pageNo-1)*pageSize;
        return petHelpDao.findPethelpList(pyl,pageSize,pethelpName,pethelpUserPhone);
    }

    /**
     * 根据ID查询救助队
     * @param pethelpId
     * @return
     */
    @Override
    public Pethelp findPethelpById(Integer pethelpId) {
        return petHelpDao.findPethelpById(pethelpId);
    }

    /**
     * 总条数
     * @param pethelpName
     * @param pethelpUserPhone
     * @return
     */
    @Override
    public Integer PethelpCount(String pethelpName, String pethelpUserPhone) {
        return petHelpDao.PethelpCount(pethelpName,pethelpUserPhone);
    }

    /**
     * 新增救助队
     * @param pethelp
     * @return
     */
    @Override
    public Integer savePethelp(Pethelp pethelp) {
        return petHelpDao.savePethelp(pethelp);
    }

    /**
     * 修改救助队信息
     * @param pethelp
     * @return
     */
    @Override
    public Integer updatePethelp(Pethelp pethelp) {
        return petHelpDao.updatePethelp(pethelp);
    }

    /**
     * 删除救助队
     * @param pethelpId
     * @return
     */
    @Override
    public Integer deletePethelpById(Integer pethelpId) {
        return petHelpDao.deletePethelpById(pethelpId);
    }

    @Override
    public Integer seePethelp(Pethelp pethelp) {
        return petHelpDao.seePethelp(pethelp);
    }
}

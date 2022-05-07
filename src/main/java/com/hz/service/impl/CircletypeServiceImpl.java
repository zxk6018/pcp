package com.hz.service.impl;

import com.hz.dao.CircletypeDao;
import com.hz.pojo.Circletype;
import com.hz.service.CircletypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CircletypeServiceImpl implements CircletypeService {

    @Autowired
    private CircletypeDao circletypeDao;

    @Override
    public List<Circletype> findCircletypetList(Integer page, Integer pageSize, String circletypeName, String circletypeTime) {
        Integer pyl = (page-1)*pageSize;
        return circletypeDao.findCircletypetList(pyl,pageSize,circletypeName,circletypeTime);
    }

    @Override
    public Integer circleTypeCount(String circletypeName, String circletypeTime) {
        return circletypeDao.circleTypeCount(circletypeName,circletypeTime);
    }

    @Override
    public Integer saveCircletype(Circletype circletype) {
        return circletypeDao.saveCircletype(circletype);
    }

    @Override
    public Integer deleteCircletypeById(Integer circletypeId) {
        return circletypeDao.deleteCircletypeById(circletypeId);
    }

    @Override
    public Circletype findCircletypeById(Integer circletypeId) {
        return circletypeDao.findCircletypeById(circletypeId);
    }

    @Override
    public Integer updateCircletype(Circletype circletype) {
        return circletypeDao.updateCircletype(circletype);
    }

    @Override
    public Integer seeCircletype(Circletype circletype) {
        return circletypeDao.seeCircletype(circletype);
    }
}

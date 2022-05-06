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

    @Override
    public List<Adopt> findAdoptList(Integer page, Integer pageSize, String adoptType, String adoptTime) {
        Integer pyl = (page-1)*pageSize;
        return adoptDao.findAdoptList(pyl,pageSize,adoptType,adoptTime);
    }

    @Override
    public Integer AdoptCount(String adoptType, String adoptTime) {
        return adoptDao.AdoptCount(adoptType,adoptTime);
    }

    @Override
    public Integer saveAdopt(Adopt adopt) {
        return adoptDao.saveAdopt(adopt);
    }

    @Override
    public Integer updateAdopt(Adopt adopt) {
        return adoptDao.updateAdopt(adopt);
    }

    @Override
    public Integer deleteAdoptById(Integer adoptId) {
        return adoptDao.deleteAdoptById(adoptId);
    }

    @Override
    public Integer seeAdopt(Adopt adopt) {
        return adoptDao.seeAdopt(adopt);
    }


    @Override
    public Adopt findAdoptById(Integer adoptId) {
        return adoptDao.findAdoptById(adoptId);
    }


}

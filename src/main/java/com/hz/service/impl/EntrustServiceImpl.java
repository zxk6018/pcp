package com.hz.service.impl;

import com.hz.dao.EntrustDao;
import com.hz.pojo.Entrust;
import com.hz.service.EntrustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrustServiceImpl implements EntrustService {
    @Autowired
    public EntrustDao entrustDao;

    @Override
    public List<Entrust> findEntrustList(Integer page, Integer pageSize, String entrustDisposetime, Integer entrustUserId) {
        Integer pyl = (page-1)*pageSize;
        return entrustDao.findEntrustList(pyl,pageSize,entrustDisposetime,entrustUserId);
    }

    @Override
    public Integer updateEntrust(Entrust entrust) {
        return entrustDao.updateEntrust(entrust);
    }



    @Override
    public Integer entrustCount(String entrustDisposetime, Integer entrustUserId) {
        return entrustDao.entrustCount(entrustDisposetime,entrustUserId);
    }

    @Override
    public Integer deleteEntrustById(Integer entrustId) {
        return entrustDao.deleteEntrustById(entrustId);
    }

    @Override
    public Integer saveEntrust(Entrust entrust) {
        return entrustDao.saveEntrust(entrust);
    }

    @Override
    public Entrust findEntrustById(Integer entrustId) {
        return entrustDao.findEntrustById(entrustId);
    }

    @Override
    public Integer seeEntrust(Entrust entrust) {
        return entrustDao.seeEntrust(entrust);
    }
}

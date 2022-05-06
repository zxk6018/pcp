package com.hz.service.impl;


import com.hz.dao.RelationDao;
import com.hz.pojo.Relation;
import com.hz.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RelationServiceImpl implements RelationService {
    @Autowired
    private RelationDao relationDao;
    /**
     * 根据ID删除
     * @param relationId
     * @return
     */
    @Override
    public Integer deleteRelationById( Integer relationId ) {
        return relationDao.deleteRelationById(relationId );
    }
    /**
     * 根据ID修改
     * @param relation
     * @return
     */
    @Override
    public Integer updateRelation( Relation relation ) {
        return relationDao.updateRelation( relation );
    }
    /**
     * 添加
     * @param relation
     * @return
     */
    @Override
    public Integer saveRelation( Relation relation ) {
        return relationDao.saveRelation( relation );
    }
    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param relationAdoptId
     * @param relationUserId
     * @return
     */
    @Override
    public List<Relation> findRelationList( Integer pageNo, Integer pageSize, Integer relationAdoptId, Integer relationUserId ) {
        Integer pyl =(pageNo-1)*pageSize;
        return relationDao.findRelationList( pyl,pageSize,relationAdoptId,relationUserId );
    }
    /**
     * 获取总数据数
     * @param relationAdoptId
     * @param relationUserId
     * @return
     */
    @Override
    public Integer relationCount( Integer relationAdoptId, Integer relationUserId ) {
        return relationDao.relationCount( relationAdoptId, relationUserId);
    }
    /**
     * 根据ID查找
     * @param relationId
     * @return
     */
    @Override
    public Relation findRelationById( Integer relationId ) {
        return relationDao.findRelationById( relationId );
    }
    /**
     * 查看寄养联系方式具体信息
     * @param relation
     * @return
     */
    @Override
    public Integer seeRelation( Relation relation ) {
        return relationDao.seeRelation( relation );
    }
}

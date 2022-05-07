package com.hz.service;

import com.hz.pojo.Relation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationService {

    /**
     * 删除寄养联系信息ID
     * @param relationId
     * @return
     */
    Integer deleteRelationById(Integer relationId);

    /**
     * 修改
     * @param relation
     * @return
     */
    Integer updateRelation(Relation relation);
    /**
     * 新增
     * @param relation
     * @return
     */
    Integer saveRelation(Relation relation);
    /**
     * 查询
     * @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @return
     */
    List<Relation> findRelationList(
            @Param( "pyl" )Integer pyl,
            @Param( "pageSize" )Integer pageSize,
            @Param( "relationAdoptId" )Integer relationAdoptId,
            @Param( "relationUserId" )Integer relationUserId
    );
    /**
     * 总记录数
     * @return
     */
    Integer relationCount(
            Integer relationAdoptId,
            Integer relationUserId
    );
    /**
     * 根据ID  获得寄养信息
     * @param relationId
     * @return
     */
    Relation findRelationById(Integer relationId);
    /**
     * 查看具体信息
     * @param relation
     * @return
     */
    Integer seeRelation(Relation relation);
}

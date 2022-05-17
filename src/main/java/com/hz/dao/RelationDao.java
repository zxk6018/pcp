package com.hz.dao;

import com.hz.pojo.Relation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationDao {

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
    List<Relation>findRelationList(
            @Param( "pyl" )Integer pyl,
            @Param( "pageSize" )Integer pageSize,
            @Param( "relationPhone" )String relationPhone,
            @Param( "relationTime" )String relationTime
    );
    /**
     * 总记录数
     * @return
     */
    Integer relationCount(
            @Param( "relationPhone" )String relationPhone,
            @Param( "relationTime" )String relationTime
    );
    /**
     * 根据ID获取领养人信息
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

package com.hz.service;

import com.hz.pojo.Circletype;

import java.util.List;

public interface CircletypeService {
    /**
     * 查询文章类型
     * @param pyl
     * @param pageSize
     * @return
     */
    List<Circletype> findCircletypetList( Integer pyl,
                                          Integer pageSize,
                                          String circletypeName,
                                          String circletypeTime
    );
    /**
     * 总记录数
     * @return
     */
    Integer circleTypeCount( String circletypeName,
                             String circletypeTime);

    /**
     * 新增文章类型
     * @param circletype
     * @return
     */
    Integer saveCircletype(Circletype circletype);

    /**
     * 删除文章
     * @param circletypeId
     * @return
     */
    Integer deleteCircletypeById(Integer circletypeId);
    /**
     * 根据ID  获得用户对象
     * @param circletypeId
     * @return
     */
    Circletype findCircletypeById(Integer circletypeId);

    /**
     * 修改文章类型
     * @param circletype
     * @return
     */

    Integer updateCircletype(Circletype circletype);


    /**
     * 查看文章类型
     * @param circletype
     * @return
     */
    Integer seeCircletype(Circletype circletype);
}

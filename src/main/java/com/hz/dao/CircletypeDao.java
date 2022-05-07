package com.hz.dao;

import com.hz.pojo.Circletype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CircletypeDao {
    /**
     * 查询文章类型
     * @param pyl
     * @param pageSize
     * @return
     */
    List<Circletype> findCircletypetList(@Param("pyl") Integer pyl,
                                   @Param("pageSize") Integer pageSize,
                                   @Param("circletypeName") String circletypeName,
                                   @Param("circletypeTime") String circletypeTime
    );
    /**
     * 总记录数
     * @return
     */
    Integer circleTypeCount(@Param("circletypeName") String circletypeName,
                       @Param("circletypeTime") String circletypeTime);


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

package com.hz.dao;

import com.hz.pojo.Adopt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdoptDao {

    /**
     * 查询发布领养与寄养信息
     * @param pyl
     * @param pageSize
     * @return
     */
    List<Adopt> findAdoptList(@Param("pyl") Integer pyl,
                            @Param("pageSize") Integer pageSize,
                            @Param("adoptType") String adoptType,
                            @Param("adoptTime") String adoptTime
    );
    /**
     * 总记录数
     * @return
     */
    Integer AdoptCount(@Param("adoptType") String adoptType,
                     @Param("adoptTime") String adoptTime);

    /**
     * 新增
     * @param adopt
     * @return
     */
    Integer saveAdopt(Adopt adopt);

    /**
     * 修改
     * @param adopt
     * @return
     */

    Integer updateAdopt(Adopt adopt);

    /**
     * 根据ID  获得对象
     * @param adoptId
     * @return
     */
    Adopt findAdoptById(Integer adoptId);

    /**
     * 删除
     * @param adoptId
     * @return
     */
    Integer deleteAdoptById(Integer adoptId);



    /**
     * 查看详情
     * @param adopt
     * @return
     */
    Integer seeAdopt(Adopt adopt);



}

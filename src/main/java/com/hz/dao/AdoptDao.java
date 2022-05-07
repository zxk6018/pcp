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
                            @Param("adoptDisposetime") String adoptDisposetime
    );
    /**
     * 总记录数
     * @return
     */
    Integer AdoptCount(@Param("adoptType") String adoptType,
                     @Param("adoptDisposetime") String adoptDisposetime);

    /**
     * 新增发布领养与寄养信息
     * @param adopt
     * @return
     */
    Integer saveAdopt(Adopt adopt);

    /**
     * 修改发布领养与寄养信息
     * @param adopt
     * @return
     */

    Integer updateAdopt(Adopt adopt);

    /**
     * 根据ID  获得发布领养与寄养信息
     * @param adoptId
     * @return
     */
    Adopt findAdoptById(Integer adoptId);

    /**
     * 删除发布领养与寄养信息
     * @param adoptId
     * @return
     */
    Integer deleteAdoptById(Integer adoptId);



    /**
     * 查看发布领养与寄养信息详情
     * @param adopt
     * @return
     */
    Integer seeAdopt(Adopt adopt);

}

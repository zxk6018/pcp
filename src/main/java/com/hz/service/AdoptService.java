package com.hz.service;

import com.hz.pojo.Adopt;

import java.util.List;

public interface AdoptService {

    /**
     * 查询发布领养与寄养信息
     * @param pyl
     * @param pageSize
     * @return
     */
    List<Adopt> findAdoptList(Integer pyl,
                              Integer pageSize,
                              String adoptType,
                              String adoptTime
    );
    /**
     * 总记录数
     * @return
     */
    Integer AdoptCount(String adoptType,
                       String adoptTime);

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

    /**
     * 根据ID  获得发布领养与寄养信息
     * @param adoptId
     * @return
     */
    Adopt findAdoptById(Integer adoptId);
}

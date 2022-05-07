package com.hz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.pojo.Pettype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/5 14:05
 * @Version 1.5
 */
public interface PetTypeService extends IService<Pettype> {
    /**
     * 查询宠物类型
     *
     * @param pyl      偏移量
     * @param pageSize 每页显示数量
     * @return
     */
    List<Pettype> findPettypeList(@Param("pyl") Integer pyl,
                                  @Param("pageSize") Integer pageSize,
                                  @Param("pettypeId") String pettypeId,
                                  @Param("pettypeName") String pettypeName);

    /**
     * 总记录数
     *
     * @return
     */
    Integer PettypeCount(@Param("pettypeId") String pettypeId,
                         @Param("pettypeName") String pettypeName);

    /**
     * 根据ID  获得宠物类型
     *
     * @param pettypeId
     * @return
     */
    Pettype findPettypeById(Integer pettypeId);
    /**
     * 新增宠物类型
     * @param pettype
     * @return
     */
    Integer savePettype(Pettype pettype);

    /**
     * 删除宠物类型
     * @param pettypeId
     * @return
     */
    Integer deletePettypeById(Integer pettypeId);

}

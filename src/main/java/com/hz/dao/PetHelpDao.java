package com.hz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hz.pojo.Pethelp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/3 15:46
 * @Version 1.5
 */
public interface PetHelpDao extends BaseMapper<Pethelp> {
    /**
     * 根据救助队队名和电话查询
     * @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @param pethelpName 救助队队名
     * @param pethelpUserPhone 救助队电话
     * @return
     */
    List<Pethelp> findPethelpList(@Param("pyl") Integer pyl,
                                  @Param("pageSize") Integer pageSize,
                                  @Param("pethelpName") String pethelpName,
                                  @Param("pethelpUserPhone") String pethelpUserPhone
    );

    /**
     * 总记录数
     * @return
     */
    Integer PethelpCount(@Param("pethelpName") String pethelpName,
                       @Param("pethelpUserPhone") String pethelpUserPhone);


    /**
     * 根据ID查找救助队
     * @param pethelpId
     * @return
     */
    Pethelp findPethelpById(Integer pethelpId);
    /**
     * 新增救助队
     * @param pethelp
     * @return
     */
    Integer savePethelp(Pethelp pethelp);

    /**
     * 修改救助队
     * @param pethelp
     * @return
     */
    Integer updatePethelp(Pethelp pethelp);
    /**
     * 删除救助队
     * @param pethelpId
     * @return
     */
    Integer deletePethelpById(Integer pethelpId);
    /**
     * 查看救助队详情
     * @param pethelp
     * @return
     */
    Integer seePethelp(Pethelp pethelp);
}

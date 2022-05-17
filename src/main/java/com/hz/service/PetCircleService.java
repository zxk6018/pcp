package com.hz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.pojo.Petcircle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/6 11:17
 * @Version 1.5
 */
public interface PetCircleService extends IService<Petcircle> {
    /**
     * 根据文章ID和用户ID
     * @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @param petcircleContent 发布内容
     * @param petcircleTime 发布时间
     * @return
     */
    List<Petcircle> findPetcircleList(Integer pyl,
                                      Integer pageSize,
                                      String petcircleContent,
                                      String petcircleTime
    );

    /**
     * 总记录数
     * @return
     */
    Integer PetcircleCount(String petcircleContent,
                           String petcircleTime);



    /**
     * 根据文章ID查找文章
     * @param petcircleId
     * @return
     */
    Petcircle findPetcircleById(Integer petcircleId);
    /**
     * 新增文章
     * @param petcircle
     * @return
     */
    Integer savePetcircle(Petcircle petcircle);


    /**
     * 删除救助队
     * @param petcircleId
     * @return
     */
    Integer deletePetcircleById(Integer petcircleId);
    /**
     * 查看文章详情
     * @param petcircle
     * @return
     */
    Integer seePetcircle(Petcircle petcircle);
}

package com.hz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.pojo.System;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/4 14:45
 * @Version 1.5
 */
public interface SystemService extends IService<System> {
    /**
     * 查询管理员
     * @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @return
     */

    List<System> findSystemList(@Param("pyl") Integer pyl,
                                @Param("pageSize") Integer pageSize,
                                @Param("systemId") String systemId,//权限名
                                @Param("systemName") String systemName//父级ID
    );

    /**
     * 总记录数
     * @return
     */
    Integer SystemCount(@Param("systemId") String systemId,
                        @Param("systemName") String systemName);

    /**
     * 根据ID  获得权限名
     * @param systemId
     * @return
     */
    System findSystemById(Integer systemId);

    /**
     * 新增权限
     * @param system
     * @return
     */
    Integer saveSystem(System system);
    /**
     * 删除权限
     * @param systemId
     * @return
     */
    Integer deleteSystemById(Integer systemId);

}

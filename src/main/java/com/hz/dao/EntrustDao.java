package com.hz.dao;

import com.hz.pojo.Entrust;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EntrustDao {
    /*
     * 查询
     *  @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @return
     * */
    List<Entrust> findEntrustList(@Param("pyl") Integer pyl,
                              @Param("pageSize") Integer pageSize,
                              @Param("entrustAddress") String entrustAddress,
                              @Param("userName") String userName
    );
    /*
     * 修改角色
     * @param entrust
     * @return
     * */
    Integer updateEntrust(Entrust entrust);


    /*
     * 总记录数
     * @return
     * */
    Integer entrustCount(@Param("entrustAddress") String entrustAddress,
                         @Param("userName") String userName
    );

    /*
     * s删除角色
     * @param roleID
     * @return
     * */
    Integer deleteEntrustById(Integer entrustId);

    /*
     * 新增用户
     *
     * */
    Integer saveEntrust(Entrust entrust);

    /*
     * 根据ID  获得用户对象
     * @param roleId
     * @return
     * */
    Entrust findEntrustById(Integer entrustId);

    /*
     * 查看管理员具体信息
     * @param role
     * @return
     * */
    Integer seeEntrust(Entrust entrust);

}

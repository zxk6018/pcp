package com.hz.service;

import com.hz.pojo.Entrust;


import java.util.List;

public interface EntrustService {
    /*
     * 查询
     *  @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @return
     * */
    List<Entrust> findEntrustList(Integer pyl,
                                  Integer pageSize,
                                  String entrustDisposetime,
                                  Integer entrustUserId
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
    Integer entrustCount(String entrustDisposetime,
                         Integer entrustUserId
    );

    /*
     * s删除角色
     * @param entrustId
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
     * @param entrustId
     * @return
     * */
    Entrust findEntrustById(Integer entrustId);

    /*
     * 查看管理员具体信息
     * @param entrust
     * @return
     * */
    Integer seeEntrust(Entrust entrust);
}

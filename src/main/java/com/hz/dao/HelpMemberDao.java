package com.hz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hz.pojo.Helpmember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/5 17:25
 * @Version 1.5
 */
public interface HelpMemberDao extends BaseMapper<Helpmember> {
    /**
     * 根据救助队队员ID和救助队ID查询
     * @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @param helpmemberId 救助队队员UD
     * @param helpmemberPethelpId 救助队ID
     * @return
     */
    List<Helpmember> findHelpmemberList(@Param("pyl") Integer pyl,
                                     @Param("pageSize") Integer pageSize,
                                     @Param("helpmemberId") String helpmemberId,
                                     @Param("helpmemberPethelpId") String helpmemberPethelpId
    );

    /**
     * 总记录数
     * @return
     */
    Integer HelpmemberCount(@Param("helpmemberId") String helpmemberId,
                         @Param("helpmemberPethelpId") String helpmemberPethelpId);


    /**
     * 根据ID查找救助队队员
     * @param helpmemberId
     * @return
     */
    Helpmember findHelpmemberById(Integer helpmemberId);
    /**
     * 新增救助队
     * @param helpmember
     * @return
     */
    Integer saveHelpmember(Helpmember helpmember);

    /**
     * 修改救助队
     * @param helpmember
     * @return
     */
    Integer updateHelpmember(Helpmember helpmember);
    /**
     * 删除救助队
     * @param helpmemberId
     * @return
     */
    Integer deleteHelpmemberById(Integer helpmemberId);
    /**
     * 查看救助队详情
     * @param helpmember
     * @return
     */
    Integer seeHelpmember(Helpmember helpmember);
}

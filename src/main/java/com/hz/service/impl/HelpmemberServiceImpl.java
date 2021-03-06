package com.hz.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.dao.HelpMemberDao;
import com.hz.pojo.Helpmember;
import com.hz.service.HelpmemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/5/5 17:31
 * @Version 1.5
 */
@Service
public class HelpmemberServiceImpl extends ServiceImpl<BaseMapper<Helpmember>,Helpmember> implements HelpmemberService {

    @Autowired
    private HelpMemberDao helpMemberDao;

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize 每页显示数量
     * @param helpmemberRname 姓名
     * @param helpmemberAddress 地址
     * @return
     */
    @Override
    public List<Helpmember> findHelpmemberList(Integer pageNo, Integer pageSize, String helpmemberRname, String helpmemberAddress) {
        Integer pyl = (pageNo-1)*pageSize;
        return helpMemberDao.findHelpmemberList(pyl,pageSize,helpmemberRname,helpmemberAddress);
    }

    /**
     * 查询总数
     * @param helpmemberRname
     * @param helpmemberAddress
     * @return
     */
    @Override
    public Integer HelpmemberCount(String helpmemberRname, String helpmemberAddress) {
        return helpMemberDao.HelpmemberCount(helpmemberRname,helpmemberAddress);
    }

    /**
     * 根据ID查询救助队队员信息
     * @param helpmemberId
     * @return
     */
    @Override
    public Helpmember findHelpmemberById(Integer helpmemberId) {
        return helpMemberDao.findHelpmemberById(helpmemberId);
    }

    /**
     * 新增救助队队员
     * @param helpmember
     * @return
     */
    @Override
    public Integer saveHelpmember(Helpmember helpmember) {
        return helpMemberDao.saveHelpmember(helpmember);
    }

    /**
     * 修改救助队队员信息
     * @param helpmember
     * @return
     */
    @Override
    public Integer updateHelpmember(Helpmember helpmember) {
        return helpMemberDao.updateHelpmember(helpmember);
    }

    /**
     * 根据ID删除救助队队员
     * @param helpmemberId
     * @return
     */
    @Override
    public Integer deleteHelpmemberById(Integer helpmemberId) {
        return helpMemberDao.deleteHelpmemberById(helpmemberId);
    }

    /**
     * 查看救助队队员详细信息
     * @param helpmember
     * @return
     */
    @Override
    public Integer seeHelpmember(Helpmember helpmember) {
        return helpMemberDao.seeHelpmember(helpmember);
    }
}

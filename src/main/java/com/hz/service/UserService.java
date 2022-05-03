package com.hz.service;

import com.hz.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 查询用户
     * @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @return
     */

    List<User> findUserList(Integer pyl, Integer pageSize, String userName);

    /**
     * 总记录数
     * @return
     */
    Integer UserCount(String adminName);

    /**
     * 删除用户
     * @param id
     * @return
     */
    Integer deleteUserById(Integer id);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Integer saveUser(User user);

}

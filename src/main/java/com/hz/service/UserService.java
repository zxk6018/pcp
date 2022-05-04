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

    List<User> findUserList(Integer pyl,
                            Integer pageSize,
                            String userName,
                            String userTime
    );

    /**
     * 修改用户
     * @param user
     * @return
     */

    Integer updateUser(User user);
    /**
     * 总记录数
     * @return
     */
    Integer UserCount(String userName,String userTime);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    Integer deleteUserById(Integer userId);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Integer saveUser(User user);

    /**
     * 根据ID  获得用户对象
     * @param userId
     * @return
     */
    User findUserById(Integer userId);

}

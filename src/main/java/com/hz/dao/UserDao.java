package com.hz.dao;


import com.hz.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 查询用户
     * @param pyl 偏移量
     * @param pageSize 每页显示数量
     * @return
     */

    List<User> findUserList(@Param("pyl") Integer pyl,
                            @Param("pageSize") Integer pageSize,
                            @Param("userName") String userName
    );

    /**
     * 总记录数
     * @return
     */
    Integer UserCount(String userName);

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

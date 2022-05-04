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
                            @Param("userName") String userName,
                            @Param("userTime") String userTime
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
    Integer UserCount(@Param("userName") String userName,
                      @Param("userTime") String userTime);

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

    /**
     * 查看管理员具体信息
     * @param user
     * @return
     */
    Integer seeAdmin(User user);
}

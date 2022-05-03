package com.hz.service.impl;

import com.hz.dao.UserDao;
import com.hz.pojo.User;
import com.hz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findUserList(Integer pageNo, Integer pageSize, String userName) {
        Integer pyl = (pageNo-1)*pageSize;
        return userDao.findUserList(pyl, pageSize, userName);
    }

    @Override
    public Integer UserCount(String user_name) {
        return userDao.UserCount(user_name);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public Integer saveUser(User user) {
        return userDao.saveUser(user);
    }
}

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
    public List<User> findUserList(Integer page, Integer pageSize, String userName,String userPhone) {
        Integer pyl = (page-1)*pageSize;
        return userDao.findUserList(pyl, pageSize, userName,userPhone);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public Integer UserCount(String userName,String userPhone) {
        return userDao.UserCount(userName,userPhone);
    }

    @Override
    public Integer deleteUserById(Integer userId) {
        return userDao.deleteUserById(userId);
    }

    @Override
    public Integer saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public User findUserById(Integer userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public Integer seeUser(User user) {
        return userDao.seeUser(user);
    }

    @Override
    public User loginUser(String userName, String userPassword) {
        return userDao.loginUser(userName,userPassword);
    }
}
